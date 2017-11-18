package org.acmw.eco;

import java.util.Optional;

import org.acmw.data.customdata.entity.player.PlayerCurrency;
import org.acmw.entity.living.human.player.ACMWAccount;
import org.acmw.entity.living.human.player.ACMWPlayer;
import org.acmw.entity.living.human.player.ACMWUser;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public class ACMWEco extends ACMWOutdatedEco {

	/**
	 * because Britain
	 */
	@Override
	public String currencyNamePlural() {
		return "Pound";
	}

	@Override
	public String currencyNameSingular() {
		return "£";
	}
	
	@Override
	public String format(double arg0) {
		return currencyNameSingular() + arg0;
	}
	
	@Override
	public int fractionalDigits() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean hasBankSupport() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String getName() {
		return "ACMWEco Vault helper";
	}

	@Deprecated
	@Override
	public EconomyResponse depositPlayer(OfflinePlayer oPlayer, double amount) {
		ACMWAccount account;
		if(oPlayer.isOnline()) {
			account = ACMWPlayer.getPlayer((Player)oPlayer);
		} else {
			account = new ACMWUser(oPlayer);
		}
		Optional<PlayerCurrency> opCurrency = account.getFirstData(PlayerCurrency.class);
		if(opCurrency.isPresent()) {
			PlayerCurrency currency = opCurrency.get();
			return currency.disposit(new EcoCause(null, amount, "third party plugin - unknown"));
		}
		return new EconomyResponse(amount, 0, ResponseType.FAILURE, "PlayerCurrency data could not be found. Maybe disabled");
	}
	
	@Deprecated
	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer oPlayer, double amount) {
		ACMWAccount account;
		if(oPlayer.isOnline()) {
			account = ACMWPlayer.getPlayer((Player)oPlayer);
		} else {
			account = new ACMWUser(oPlayer);
		}
		Optional<PlayerCurrency> opCurrency = account.getFirstData(PlayerCurrency.class);
		if(opCurrency.isPresent()) {
			PlayerCurrency currency = opCurrency.get();
			return currency.withdraw(new EcoCause(null, amount, "third party plugin - unknown"));
		}
		return new EconomyResponse(amount, 0, ResponseType.FAILURE, "PlayerCurrency data could not be found. Maybe disabled");
	}

	@Deprecated
	@Override
	public double getBalance(OfflinePlayer oPlayer) {
		ACMWAccount account;
		if(oPlayer.isOnline()) {
			account = ACMWPlayer.getPlayer((Player)oPlayer);
		} else {
			account = new ACMWUser(oPlayer);
		}
		Optional<PlayerCurrency> opCurrency = account.getFirstData(PlayerCurrency.class);
		if(opCurrency.isPresent()) {
			PlayerCurrency currency = opCurrency.get();
			return currency.getAmount();
		}
		return 0;
	}

	@Deprecated
	@Override
	public boolean has(OfflinePlayer oPlayer, double amount) {
		ACMWAccount account;
		if(oPlayer.isOnline()) {
			account = ACMWPlayer.getPlayer((Player)oPlayer);
		} else {
			account = new ACMWUser(oPlayer);
		}
		Optional<PlayerCurrency> opCurrency = account.getFirstData(PlayerCurrency.class);
		if(opCurrency.isPresent()) {
			PlayerCurrency currency = opCurrency.get();
			return (currency.getAmount() < amount);
		}
		return false;
	}

	@Deprecated
	@Override
	public boolean hasAccount(OfflinePlayer oPlayer) {
		ACMWAccount account;
		if(oPlayer.isOnline()) {
			account = ACMWPlayer.getPlayer((Player)oPlayer);
		} else {
			account = new ACMWUser(oPlayer);
		}
		Optional<PlayerCurrency> opCurrency = account.getFirstData(PlayerCurrency.class);
		return opCurrency.isPresent();
	}
	
	@Deprecated
	@Override
	public boolean createPlayerAccount(OfflinePlayer oPlayer) {
		if(hasAccount(oPlayer)) {
			return true;
		}
		ACMWAccount account;
		if(oPlayer.isOnline()) {
			account = ACMWPlayer.getPlayer((Player)oPlayer);
		} else {
			account = new ACMWUser(oPlayer);
		}
		account.addData(new PlayerCurrency());
		return false;
	}


	@Deprecated
	@Override
	public boolean hasAccount(OfflinePlayer arg0, String arg1) {
		return hasAccount(arg0);
	}
	
	@Deprecated
	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		return withdrawPlayer(arg0, arg2);
	}

	@Deprecated
	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0, String arg1) {
		return createPlayerAccount(arg0);
	}
	
	@Deprecated
	@Override
	public boolean has(OfflinePlayer arg0, String arg1, double arg2) {
		return has(arg0, arg2);
	}
	
	@Deprecated
	@Override
	public double getBalance(OfflinePlayer arg0, String arg1) {
		return getBalance(arg0);
	}
	
	@Deprecated
	@Override
	public EconomyResponse depositPlayer(OfflinePlayer oPlayer, String worldname, double amount) {
		return depositPlayer(oPlayer, amount);
	}

}
