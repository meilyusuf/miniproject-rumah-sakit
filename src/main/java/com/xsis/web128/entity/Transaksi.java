package com.xsis.web128.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Transaksi {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String traderId;
	private String currencyCode;
	private String BuySell;
	@Temporal(TemporalType.DATE)
	private Date tanggalTransaksi;
	private Integer rate;
	private Integer amount;
	private Integer profitLossIDR;
	private String TransactionRemark;
	private Integer balance;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTraderId() {
		return traderId;
	}
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getBuySell() {
		return BuySell;
	}
	public void setBuySell(String buySell) {
		BuySell = buySell;
	}
	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}
	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getProfitLossIDR() {
		return profitLossIDR;
	}
	public void setProfitLossIDR(Integer profitLossIDR) {
		this.profitLossIDR = profitLossIDR;
	}
	public String getTransactionRemark() {
		return TransactionRemark;
	}
	public void setTransactionRemark(String transactionRemark) {
		TransactionRemark = transactionRemark;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}