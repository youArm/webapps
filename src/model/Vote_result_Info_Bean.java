package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Vote_result_Info_Bean implements Serializable{
	private ArrayList<Vote_result_bean> VortArray = new ArrayList<Vote_result_bean>();
	private static final long serialVersionUID = 1L;

	public Vote_result_Info_Bean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ArrayList<Vote_result_bean> getvoteArray() {
		return VortArray;
		}
	public void setVortArray(ArrayList<Vote_result_bean> list) {
		this.VortArray = list;
		}
	public void addList(Vote_result_bean obj){
		VortArray.add(obj);
		}
	public int getArraySize(){
		return VortArray.size();
	}
	
	
}
