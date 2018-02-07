package com.nf.entity;

import java.io.Serializable;
import java.util.Date;

public class AssetQuota implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 基金名称
	private String v_jjmc;
	
	// 恒生基金编号
	private String v_jjdm;
	
	private Double n_cash_ratio;
	
	private Double n_flow_asset_ratio;
	
	private Double n_unliquidity_asset_ratio;
	
	private Double n_left_day;
	
	private Double n_left_3aasset;
	
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getV_jjmc() {
		return v_jjmc;
	}

	public void setV_jjmc(String v_jjmc) {
		this.v_jjmc = v_jjmc;
	}

	public String getV_jjdm() {
		return v_jjdm;
	}

	public void setV_jjdm(String v_jjdm) {
		this.v_jjdm = v_jjdm;
	}

	public Double getN_cash_ratio() {
		return n_cash_ratio;
	}

	public void setN_cash_ratio(Double n_cash_ratio) {
		this.n_cash_ratio = n_cash_ratio;
	}

	public Double getN_flow_asset_ratio() {
		return n_flow_asset_ratio;
	}

	public void setN_flow_asset_ratio(Double n_flow_asset_ratio) {
		this.n_flow_asset_ratio = n_flow_asset_ratio;
	}

	public Double getN_unliquidity_asset_ratio() {
		return n_unliquidity_asset_ratio;
	}

	public void setN_unliquidity_asset_ratio(Double n_unliquidity_asset_ratio) {
		this.n_unliquidity_asset_ratio = n_unliquidity_asset_ratio;
	}

	public Double getN_left_day() {
		return n_left_day;
	}

	public void setN_left_day(Double n_left_day) {
		this.n_left_day = n_left_day;
	}

	public Double getN_left_3aasset() {
		return n_left_3aasset;
	}

	public void setN_left_3aasset(Double n_left_3aasset) {
		this.n_left_3aasset = n_left_3aasset;
	}

	@Override
	public String toString() {
		return "AssetQuota [v_jjmc=" + v_jjmc + ", v_jjdm=" + v_jjdm + ", n_cash_ratio=" + n_cash_ratio
				+ ", n_flow_asset_ratio=" + n_flow_asset_ratio + ", n_unliquidity_asset_ratio="
				+ n_unliquidity_asset_ratio + ", n_left_day=" + n_left_day + ", n_left_3aasset=" + n_left_3aasset
				+ ", time=" + time + "]";
	}

	
	
}
