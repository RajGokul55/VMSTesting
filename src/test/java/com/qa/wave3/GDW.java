package com.qa.wave3;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GDW extends CommonMethods {
	//Connection object
	Connection con = null;
	
	String GDW_User = "GDWRO";
	String GDW_DEV_URL = "jdbc:oracle:thin:@fccadbdev01.na.gilead.com:1521/GDWDEV";  
	String GDW_UAT_URL = "jdbc:oracle:thin:@fcracodbtstge-scan.na.gilead.com:1521/GDWUAT";
	String GDW_SIT_URL = "jdbc:oracle:thin:@gdwtch.cfuwy0fe8303.us-west-1.rds.amazonaws.com:1521/GDWTCH";
	String GDW_DEV_UAT_SIT_Pwd = "gdwro";

	String GDW_SUPP_URL = "jdbc:oracle:thin:@gdwsup.cfuwy0fe8303.us-west-1.rds.amazonaws.com:1521/GDWSUP";
	String GDW_SUPP_Pwd = "g9wr04u";

	String Q_GDWSTG ="SELECT COUNT(*) FROM GDWSTG.STG_CALL2_DETAIL_VOD__C";
	String Q_GDWSMA_AGG ="SELECT COUNT(*) FROM GDWMA.FACT_INTERACTION_AGG";
	String Q_GDWSMA_SECURITY ="SELECT COUNT(*) FROM GDWMA.MA_USER_SECURITY";

	@BeforeTest
	public void setUp() throws Exception {
		try{
			// Make the database connection
			String dbClass = "oracle.jdbc.driver.OracleDriver";
			Class.forName(dbClass).newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	@Test(priority = 1, enabled = true)
	public void GDW_S01_DB_DEV_GDW() {
		TM_connectToDB_RunQuery(GDW_DEV_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSTG);
		TM_connectToDB_RunQuery(GDW_DEV_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_AGG);
		TM_connectToDB_RunQuery(GDW_DEV_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_SECURITY);
	}

	@Test(priority = 2, enabled = true)
	public void GDW_S02_DB_UAT_GDW() {
		TM_connectToDB_RunQuery(GDW_UAT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSTG);
		TM_connectToDB_RunQuery(GDW_UAT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_AGG);
		TM_connectToDB_RunQuery(GDW_UAT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_SECURITY);
	}
	@Test(priority = 3, enabled = true)
	public void GDW_S03_DB_SIT_GDW() {
		TM_connectToDB_RunQuery(GDW_SIT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSTG);
		TM_connectToDB_RunQuery(GDW_SIT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_AGG);
		TM_connectToDB_RunQuery(GDW_SIT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_SECURITY);
	}
	@Test(priority = 4, enabled = true)
	public void GDW_S04_DB_SUPP_GDW() {
		TM_connectToDB_RunQuery(GDW_SUPP_URL, GDW_User, GDW_SUPP_Pwd,Q_GDWSTG);
		TM_connectToDB_RunQuery(GDW_SUPP_URL, GDW_User, GDW_SUPP_Pwd,Q_GDWSMA_AGG);
		TM_connectToDB_RunQuery(GDW_SUPP_URL, GDW_User, GDW_SUPP_Pwd,Q_GDWSMA_SECURITY);
	}
	@AfterTest
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}



}


/*
ODS DEV	INTGRO	5!A1RbNxE!63H#gV	INTGDEV		fcbaamdbdev01.na.gilead.com
	UAT	INTGRO	Gilead123			INTGUAT		fcracodbtstge-scan.na.gilead.com
	SUPPINTGRO	t7KnR5DH80aR		INTGSUP		fcintgdbsup01.na.gilead.com
	SIT	INTGRO	Temp4intg			INTGTEST	fcbadbtest01.na.gilead.com
GDW	DEV	GDWRO	gdwro	GDWDEV	fcbaamdbdev01.na.gilead.com
	UAT	GDWRO	gdwro	GDWUAT	fcracodbtstge-scan.na.gilead.com
	SIT	GDWRO	gdwro	GDWTCH	fccadbtch01.na.gilead.com
	SUPPGDWRO	g9wr04u	GDWSUP	sjcadbsupn01.na.gilead.com


	SELECT * FROM GDHODS.ACCOUNT;
	SELECT * FROM GALIGN.ALIGNMENT_MASTER_AUTO  WHERE SFDCID IN ( SELECT  ID 
	                                FROM      GDHODS.ACCOUNT
	                                WHERE   ISDELETED != 1  
	                                AND     ACCOUNT_STATUS_GILD__C = 'Inactive');
	SELECT * FROM GALIGN.ALIGNMENT_MASTER_AUTO;
	SELECT * FROM REPROSTER.RRTERRITORY__C ; 
	SELECT * FROM ETL_CENTRIS.CENTRIS_STATIC_EMPLOYEE;
	SELECT * FROM ETL_CAH.EXP_PRESC_DECILES;
	SELECT  DISTINCT A.ACCOUNT_ID,  F.EID_GILD__C , F.ORG_ACCOUNT_TYPE_GILD__C, 
	                                    F.ORG_ACCOUNT_SUB_TYPE_GILD__C, F.HQ_ATTRIBUTES_GILD__C, F.FIELD_ATTRIBUTES_GILD__C,
	                                    F.RECORDTYPEID,G.ZIP_VOD__C, D.NAME, A.IS_DELETED, ROW_CAUSE,SYSDATE AS VEEVA_ALGN_TBL_CRETED_DT, 
	                                    B.OWNER_ID AS GROUP_OWNER_ID, A.LAST_MODIFIED_BY_ID AS ACCOUNT_SHARE_MODIFIED_BY_ID, 
	                                    A.LAST_MODIFIED_DATE AS ACCOUNT_SHARE_LAST_MODIFIED 
	                            FROM     GALIGN.ACCOUNT_SHARE A, GALIGN.OGROUP B, GDHODS.USERTERRITORY C, GDHODS.TERRITORY D, 
	                                    GDHODS.OUSER E, GDHODS.ACCOUNT F,GDHODS.ADDRESS_VOD__C G
	                            WHERE     A.USER_OR_GROUP_ID = B.ID     
	                            AND     B.RELATED_ID = D.ID
	                            AND     D.ID = C.TERRITORYID (+)
	                            AND      C.USERID = E.ID (+)
	                            AND     A.ACCOUNT_ID = F.ID
	                            AND     F.ID = G.ACCOUNT_VOD__C
	                            AND     G.PRIMARY_VOD__C = 1
	                            AND     G.COUNTRY_VOD__C NOT IN ('ca', 'CA') ; 
	SELECT * FROM GDWSTG.STG_CALL2_DETAIL_VOD__C;--please query in gdw instance
	SELECT * FROM GDWMA.FACT_INTERACTION_AGG;-- please query in gdw instance
	SELECT * FROM GDWMA.MA_USER_SECURITY;-- please query in gdw instance

 */




