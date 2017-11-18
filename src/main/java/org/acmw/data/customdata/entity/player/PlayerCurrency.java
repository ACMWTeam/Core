package org.acmw.data.customdata.entity.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.acmw.CorePlugin;
import org.acmw.data.CustomData;
import org.acmw.data.DataHolder;
import org.acmw.data.SerializableData;
import org.acmw.eco.EcoCause;
import org.acmw.entity.living.human.player.ACMWAccount;
import org.acmw.exception.InvalidCreateParameters;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public class PlayerCurrency implements SerializableData<ACMWAccount>{

	double cash;
	List<EcoCause> cause;
	
	public static final String CURRENCY_PATH = "currency";
	public static final String CAUSE_PATH = "cause";
	
	public Set<EcoCause> getCauses(){
		return new HashSet<>(cause);
	}
	
	public EconomyResponse disposit(EcoCause cause) {
		if(cash < cause.getAmount()) {
			return new EconomyResponse(cause.getAmount(), cash, ResponseType.FAILURE, "Not enough cash");
		}
		cash = cash - cause.getAmount();
		this.cause.add(cause);
		return new EconomyResponse(cause.getAmount(), cash, ResponseType.SUCCESS, "");
	}
	
	public EconomyResponse withdraw(EcoCause cause) {
		cash = cash + cause.getAmount();
		this.cause.add(cause);
		return new EconomyResponse(cause.getAmount(), cash, ResponseType.SUCCESS, "");
	}
	
	public double getAmount() {
		return cash;
	}
	
	@Override
	public String getName() {
		return "Player Real Currency";
	}

	@Override
	public JavaPlugin getPlugin() {
		return CorePlugin.getPlugin();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <H extends DataHolder> CustomData<H> clone(Class<H> holderClass) {
		if(!(holderClass.isAssignableFrom(ACMWAccount.class))) {
			return null;
		}
		PlayerCurrency currency = new PlayerCurrency();
		currency.cash = this.cash;
		currency.cause = this.cause;
		return (CustomData<H>)currency;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <H extends DataHolder> CustomData<H> clone(CustomData<H> holder) {
		if(!(holder instanceof PlayerCurrency)) {
			return null;
		}
		PlayerCurrency currency = (PlayerCurrency)holder;
		currency.cash = this.cash;
		currency.cause = this.cause;
		return (CustomData<H>)currency;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <H extends DataHolder> CustomData<H> clone(H holder) {
		if(!(holder instanceof ACMWAccount)) {
			return null;
		}
		PlayerCurrency currency = new PlayerCurrency();
		currency.cash = this.cash;
		currency.cause = this.cause;
		return (CustomData<H>)currency;
	}

	@Override
	public void onCreation(ACMWAccount holder, Object... parameters) throws InvalidCreateParameters {
		for(Object obj : parameters) {
			if(obj instanceof Double) {
				cash = (double)obj;
			}
		}
		
	}

	@Override
	public void onSave(ConfigurationSection config) {
		List<String> list = new ArrayList<>();
		cause.stream().forEach(c -> list.add(c.toString()));
		config.set(CURRENCY_PATH, cash);
		config.set(CAUSE_PATH, list);
	}

	@Override
	public void onLoad(ConfigurationSection config) {
		cash = config.getDouble(CURRENCY_PATH);
		config.getStringList(CAUSE_PATH).stream().forEach(c -> {
			Optional<EcoCause> opCause = EcoCause.fromString(c);
			if(opCause.isPresent()) {
				cause.add(opCause.get());
			}
		});
	}

}
