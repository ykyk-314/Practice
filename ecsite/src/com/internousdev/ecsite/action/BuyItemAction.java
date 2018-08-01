package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private int count;
	private String pay;

	public String execute(){

		String result=SUCCESS;

		session.put("count", count); //　buyItem.jspで選択した個数countをセッションに入れる

//		文字列として入っているcount,buyItem_priceをそれぞれint型に変換する
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());

//		int型にした＜個数×値段＞を合計金額としてセッションに入れる
		session.put("total_price",intCount * intPrice);

//		文字列のpaymentを設定
		String payment;

//		もしbuyItem.jspで選択した支払い方法payが１なら現金払い、それ以外（２）ならクレジットとして
//		セッションに入れる
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}
		return result;

	}

	public void setCount(int count){
		this.count=count;
	}
	public void setPay(String pay){
		this.pay=pay;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

}
