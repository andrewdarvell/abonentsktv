package ru.darvell.ktv.dao;


import ru.darvell.ktv.logic.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {

	public void addContract(Contract contract) throws SQLException;
	public void updateContract(Contract contract) throws SQLException;
	public Contract getContractById(Long contractId) throws SQLException;
	public List getAllContracts() throws SQLException;
	public void deleteContract(Contract contract) throws SQLException;


}
