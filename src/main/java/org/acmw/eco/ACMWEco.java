package org.acmw.eco;

import java.util.List;

import org.bukkit.OfflinePlayer;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public class ACMWEco implements Economy {

	@Deprecated
	@Override
	public EconomyResponse bankBalance(String arg0) {
		return null;
	}

	@Deprecated
	@Override
	public EconomyResponse bankDeposit(String arg0, double arg1) {
		return null;
	}

	@Deprecated
	@Override
	public EconomyResponse bankHas(String arg0, double arg1) {
		return null;
	}

	@Deprecated
	@Override
	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		return null;
	}

	@Deprecated
	@Override
	public EconomyResponse createBank(String arg0, String arg1) {
		return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "Bank Accounts are not supported");
	}

	@Deprecated
	@Override
	public EconomyResponse createBank(String arg0, OfflinePlayer arg1) {
		return new EconomyResponse(0, 0, ResponseType.NOT_IMPLEMENTED, "Bank Accounts are not supported");
	}

	@Deprecated
	@Override
	public boolean createPlayerAccount(String arg0) {
		return false;
	}

	@Deprecated
	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0) {
		return false;
	}

	@Deprecated
	@Override
	public boolean createPlayerAccount(String arg0, String arg1) {
		return false;
	}

	@Deprecated
	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0, String arg1) {
		return false;
	}

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

	@Deprecated
	@Override
	public EconomyResponse deleteBank(String arg0) {
		return null;
	}

	@Deprecated
	@Override
	public EconomyResponse depositPlayer(String arg0, double arg1) {
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
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
	public double getBalance(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(OfflinePlayer arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(OfflinePlayer arg0, String arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getBanks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "ACMWEco Vault helper";
	}

	@Override
	public boolean has(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean has(OfflinePlayer arg0, double arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean has(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean has(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasBankSupport() {
		return false;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, OfflinePlayer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, OfflinePlayer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
