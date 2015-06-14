package com.mystore.sqlbuilder;

import java.util.ArrayList;
import java.util.List;

import com.mystore.sqlbuilder.SqlBuilderEnum.EnumLogicOperator;
import com.mystore.sqlbuilder.SqlBuilderEnum.EnumOperator;

public class WhereStruct 
{
	
	public String columnName;
	public List<Object> colValueList;
	public EnumOperator colOperator;
	public EnumLogicOperator logicOperator;
	
	public WhereStruct()
	{
		this.colValueList = new ArrayList<Object>();
	}
}
