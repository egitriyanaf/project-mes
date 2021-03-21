package com.project.common;

import java.util.ArrayList;
import java.util.List;
/**
*
* @author Ridwan
*/
public class DataTables {
    private Integer sEcho;

    private String sSearch;

    private List<String> mDataProp = new ArrayList<String>();

    private Integer iSortingCols;
    private List<Integer> iSortCol = new ArrayList<Integer>();
    private List<String> sSortDir = new ArrayList<String>();

    private Integer iDisplayStart;
    private Integer iDisplayLength;
    private Integer iColumns;

    private Long iTotalRecords;
    private Long iTotalDisplayRecords;
    private List<Boolean> bSortable = new ArrayList<Boolean>();

    @SuppressWarnings("rawtypes")
	private List aaData = new ArrayList();

    /**
     *
     * @param aaData
     * @param iTotalRecords
     * @return
     */
    @SuppressWarnings("rawtypes")
	public DataTables extract(List aaData, Long iTotalRecords) {
        this.aaData = aaData;
        this.iTotalRecords = this.iTotalDisplayRecords = iTotalRecords;

        return this;
    }
    
    /**
     *
     * @param source
     * @param target
     */
    public void copyData(DataTables source,DataTables target){
    	target.iDisplayLength = source.getiDisplayLength();
    	target.iDisplayStart = source.getiDisplayStart();
    	target.iSortCol = source.getiSortCol();
    	target.iSortingCols = source.getiSortingCols();
    	target.iTotalDisplayRecords = source.getiTotalDisplayRecords();
    	target.iTotalRecords =source.getiTotalRecords();
    	target.mDataProp = source.getmDataProp();
    	target.sEcho = source.getsEcho();
    	target.sSearch = source.getsSearch();
    	target.sSortDir = source.getsSortDir();
    }

    /**
     *
     * @return
     */
    public Integer getsEcho() {
        return sEcho;
    }

    /**
     *
     * @param sEcho
     */
    public void setsEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }

    /**
     *
     * @return
     */
    public String getsSearch() {
        return sSearch;
    }

    /**
     *
     * @param sSearch
     */
    public void setsSearch(String sSearch) {
        this.sSearch = sSearch;
    }

    /**
     *
     * @return
     */
    public Integer getiSortingCols() {
        return iSortingCols;
    }

    /**
     *
     * @return
     */
    public List<Integer> getiSortCol() {
        return iSortCol;
    }

    /**
     *
     * @param iSortCol
     */
    public void setiSortCol(List<Integer> iSortCol) {
        this.iSortCol = iSortCol;
    }

    /**
     *
     * @return
     */
    public List<String> getmDataProp() {
        return mDataProp;
    }

    /**
     *
     * @param mDataProp
     */
    public void setmDataProp(List<String> mDataProp) {
        this.mDataProp = mDataProp;
    }

    /**
     *
     * @return
     */
    public List<String> getsSortDir() {
        return sSortDir;
    }

    /**
     *
     * @param sSortDir
     */
    public void setsSortDir(List<String> sSortDir) {
        this.sSortDir = sSortDir;
    }

    /**
     *
     * @param iSortingCols
     */
    public void setiSortingCols(Integer iSortingCols) {
        this.iSortingCols = iSortingCols;
    }

    /**
     *
     * @return
     */
    public Integer getiDisplayStart() {
        return iDisplayStart;
    }

    /**
     *
     * @param iDisplayStart
     */
    public void setiDisplayStart(Integer iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    /**
     *
     * @return
     */
    public Integer getiDisplayLength() {
        return iDisplayLength;
    }

    /**
     *
     * @param iDisplayLength
     */
    public void setiDisplayLength(Integer iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    /**
     *
     * @return
     */
    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    /**
     *
     * @param iTotalRecords
     */
    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    /**
     *
     * @return
     */
    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    /**
     *
     * @param iTotalDisplayRecords
     */
    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
	public List getAaData() {
        return aaData;
    }

    /**
     *
     * @param aaData
     */
    @SuppressWarnings("rawtypes")
	public void setAaData(List aaData) {
        this.aaData = aaData;
    }

	/**
	 * @return the bSortable
	 */
	public List<Boolean> getbSortable() {
		return bSortable;
	}

	/**
	 * @param bSortable the bSortable to set
	 */
	public void setbSortable(List<Boolean> bSortable) {
		this.bSortable = bSortable;
	}
    
	/**
	 * @return the iColumns
	 */
	public Integer getiColumns() {
		return iColumns;
	}

	/**
	 * @param iColumns the iColumns to set
	 */
	public void setiColumns(Integer iColumns) {
		this.iColumns = iColumns;
	}

    /**
     *
     * @return
     */
    public List<SortField> generateSortFields(){
		List<SortField> sfields = new ArrayList<SortField>();
		if (!this.mDataProp.isEmpty()) {
			for (int i =0;i<this.iSortingCols;i++){
				int colIdx = this.iSortCol.get(i);
				if (this.bSortable.get(colIdx)){
					sfields.add(new SortField(this.mDataProp.get(colIdx),this.sSortDir.get(i)));
				}
			}
		}
		return sfields;
	}

    public void setAaData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
