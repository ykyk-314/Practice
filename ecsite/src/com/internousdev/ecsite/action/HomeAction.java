package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HomeAction extends ActionSupport implements SessionAware{

//	フィールドでMap型のsessionを宣言
	public Map<String,Object> session;



	public String execute(){
//		実行したら文字列にloginを入れる
		String result="login";

//		key"id"があれば次の処理に進む
//				⇒ログイン済みでないと商品画面にいかないはず
//				ログイン済みであれば、LoginActionで、sessionに"id"keyを設定しているので、下の処理に進める
		if(session.containsKey("id")){

//			BuyItemDAOの内容をコピー
			BuyItemDAO buyItemDAO=new BuyItemDAO();

//			BuyItemDAOのgetBuyItemInfoメソッドの内容をBuyItemDTOに格納
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

//			sessionに値を設定する
//			[homeからBuyItemに移動したい、移動したときに商品情報を表示させたいので、ここでsessionを設定]

//			("key","value")…buyItemDTOのgetIdの値を、"id"keyにセット　以下同　
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

//			文字列SUCCESSで返す　（SUCCESSは、ActionSupportのinterface）
			result=SUCCESS;
		}
		return result;
	}



//	SessionAware実装（具体的な処理の設定）
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}

}
