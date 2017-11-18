package org.acmw.eco;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public abstract class ACMWOutdatedEco implements Economy {
	
	@Deprecated
	@Override
	public List<String> getBanks() {
		return new ArrayList<>();
	}
	
	@Deprecated
	@Override
	public EconomyResponse bankBalance(String arg0) {
		return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "No Bank support");
	}

	@Deprecated
	@Override
	public EconomyResponse bankDeposit(String arg0, double arg1) {
		return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "No Bank support");
	}

	@Deprecated
	@Override
	public EconomyResponse bankHas(String arg0, double arg1) {
		return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "No Bank support");
	}

	@Deprecated
	@Override
	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "No Bank support");
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
	public boolean createPlayerAccount(String arg0, String arg1) {
		return false;
	}

	@Deprecated
	@Override
	public EconomyResponse deleteBank(String arg0) {
		return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "No Bank support");
	}
	
	@Deprecated
	@Override
	public EconomyResponse depositPlayer(String arg0, double arg1) {
		return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "depositPlayer(String, Double) is out of date and must not be used");
	}
	
	@Deprecated
	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "depositPlayer(String, String, Double) is out of date and must not be used");
	}
	
	@Deprecated
	@Override
	public double getBalance(String arg0) {
		return 0;
	}
	
	
	@Deprecated
	@Override
	public double getBalance(String arg0, String arg1) {
		return 0;
	}
	@Deprecated
	@Override
	public boolean has(String arg0, double arg1) {
		return false;
	}
	
	@Override
	public boolean has(String arg0, String arg1, double arg2) {
		return false;
	}
	
	@Override
	public boolean hasAccount(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean hasAccount(String arg0, String arg1) {
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
	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
