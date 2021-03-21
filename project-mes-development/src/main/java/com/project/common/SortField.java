package com.project.common;
/**
*
* @author Ridwan
*/
public final class SortField {
	  private final String field;
	  private final String direction;
	     
    /**
     *
     * @param field
     * @param direction
     */
    public SortField(String field, String direction)
	  {
	    this.field = field;
	    this.direction = direction;
	  }
	    
    /**
     *
     * @return
     */
    public String getField() {
	    return field;
	  }
	 
    /**
     *
     * @return
     */
    public String getDirection() {
	    return direction;
	  }
}
