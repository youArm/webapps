package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Vote_Info_Bean implements Serializable{
	private ArrayList<Vote_History_Bean> VortArray = new ArrayList<Vote_History_Bean>();
	private static final long serialVersionUID = 1L;

	public Vote_Info_Bean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ArrayList<Vote_History_Bean> getvoteArray() {
		return VortArray;
		}
	public void setVortArray(ArrayList<Vote_History_Bean> list) {
		this.VortArray = list;
		}
	public void addList(Vote_History_Bean obj){
		VortArray.add(obj);
		}
	public int getArraySize(){
		return VortArray.size();
	}

}
