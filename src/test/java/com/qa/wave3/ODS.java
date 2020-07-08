package com.qa.wave3;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ODS {
	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	String ODS_User = "INTGRO";
	String ODS_DEV_URL = "jdbc:oracle:thin:@fcbaamdbdev01.na.gilead.com:1521/INTGDEV";  
	String ODS_DEV_Pwd = "5!A1RbNxE!63H#gV";

	String ODS_UAT_URL = "jdbc:oracle:thin:@fcracodbtstge-scan.na.gilead.com:1521/INTGUAT";  
	String ODS_UAT_Pwd = "Gilead123";

	String ODS_SUPP_URL = "jdbc:oracle:thin:@fcintgdbsup01.na.gilead.com:1521/INTGSUP";  
	String ODS_SUPP_Pwd = "t7KnR5DH80aR";

	String ODS_SIT_URL = "jdbc:oracle:thin:@fcbadbtest01.na.gilead.com:1521/INTGTEST";  
	String ODS_SIT_Pwd = "Temp4intg";

	String GDW_User = "GDWRO";
	String GDW_DEV_URL = "jdbc:oracle:thin:@fcbaamdbdev01.na.gilead.com:1521/GDWDEV";  
	String GDW_UAT_URL = "jdbc:oracle:thin:@fcracodbtstge-scan.na.gilead.com:1521/GDWUAT";
	String GDW_SIT_URL = "jdbc:oracle:thin:@fccadbtch01.na.gilead.com:1521/GDWTCH";
	String GDW_DEV_UAT_SIT_Pwd = "gdwro";

	String GDW_SUPP_URL = "jdbc:oracle:thin:@sjcadbsupn01.na.gilead.com:1521/GDWSUP";
	String GDW_SUPP_Pwd = "g9wr04u";

	String Q_GDHODS_Account = "SELECT COUNT(*) FROM GDHODS.ACCOUNT";// WHERE rownum <= 100";
	String Q_GALIGN_Inactive= "SELECT COUNT(*) FROM GALIGN.ALIGNMENT_MASTER_AUTO  WHERE SFDCID IN ( SELECT  ID \r\n" + 
			"	                                FROM      GDHODS.ACCOUNT\r\n" + 
			"	                                WHERE   ISDELETED != 1  \r\n" + 
			"	                                AND     ACCOUNT_STATUS_GILD__C = 'Inactive')";
	String Q_GALIGN_Auto = "SELECT COUNT(*) FROM GALIGN.ALIGNMENT_MASTER_AUTO";
	String Q_REPOSITOR = "SELECT COUNT(*) FROM REPROSTER.RRTERRITORY__C";
	String Q_ETL_Employee = "SELECT COUNT(*) FROM ETL_CENTRIS.CENTRIS_STATIC_EMPLOYEE";
	String Q_ETL_Deciles = "SELECT COUNT(*) FROM ETL_CAH.EXP_PRESC_DECILES";
	String Q_DISTINCT ="SELECT COUNT(*) FROM    GALIGN.ACCOUNT_SHARE A, GALIGN.OGROUP B, GDHODS.USERTERRITORY C, GDHODS.TERRITORY D, \r\n" + 
			"	                                    GDHODS.OUSER E, GDHODS.ACCOUNT F,GDHODS.ADDRESS_VOD__C G\r\n" + 
			"	                            WHERE   (A.USER_OR_GROUP_ID = B.ID     \r\n" + 
			"	                            AND     B.RELATED_ID = D.ID\r\n" + 
			"	                            AND     D.ID = C.TERRITORYID (+)\r\n" + 
			"	                            AND      C.USERID = E.ID (+)\r\n" + 
			"	                            AND     A.ACCOUNT_ID = F.ID\r\n" + 
			"	                            AND     F.ID = G.ACCOUNT_VOD__C\r\n" + 
			"	                            AND     G.PRIMARY_VOD__C = 1\r\n" + 
			"	                            AND     G.COUNTRY_VOD__C NOT IN ('ca', 'CA'))";

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
	public void ODS_S01_DB_DEV_GDHODS_Account() {
		TM_connectToDB_RunQuery(ODS_DEV_URL, ODS_User, ODS_DEV_Pwd,Q_GDHODS_Account );
		TM_connectToDB_RunQuery(ODS_DEV_URL, ODS_User, ODS_DEV_Pwd,Q_GALIGN_Inactive );
		TM_connectToDB_RunQuery(ODS_DEV_URL, ODS_User, ODS_DEV_Pwd,Q_GALIGN_Auto );
		TM_connectToDB_RunQuery(ODS_DEV_URL, ODS_User, ODS_DEV_Pwd,Q_REPOSITOR );
		TM_connectToDB_RunQuery(ODS_DEV_URL, ODS_User, ODS_DEV_Pwd,Q_ETL_Employee );
		TM_connectToDB_RunQuery(ODS_DEV_URL, ODS_User, ODS_DEV_Pwd, Q_ETL_Deciles);
		TM_connectToDB_RunQuery(ODS_DEV_URL, ODS_User, ODS_DEV_Pwd, Q_DISTINCT);
	}

	@Test(priority = 2, enabled = false)
	public void ODS_S02_DB_UAT_GDHODS_Account() {
		TM_connectToDB_RunQuery(ODS_UAT_URL, ODS_User, ODS_UAT_Pwd,Q_GDHODS_Account );
		TM_connectToDB_RunQuery(ODS_UAT_URL, ODS_User, ODS_UAT_Pwd,Q_GALIGN_Inactive );
		TM_connectToDB_RunQuery(ODS_UAT_URL, ODS_User, ODS_UAT_Pwd,Q_GALIGN_Auto );
		TM_connectToDB_RunQuery(ODS_UAT_URL, ODS_User, ODS_UAT_Pwd,Q_REPOSITOR );
		TM_connectToDB_RunQuery(ODS_UAT_URL, ODS_User, ODS_UAT_Pwd,Q_ETL_Employee );
		TM_connectToDB_RunQuery(ODS_UAT_URL, ODS_User, ODS_UAT_Pwd,Q_ETL_Deciles );
		TM_connectToDB_RunQuery(ODS_UAT_URL, ODS_User, ODS_UAT_Pwd,Q_DISTINCT );
	} 

	@Test(priority = 3, enabled = false)
	public void ODS_S03_DB_SUPP_GDHODS_Account() {
		TM_connectToDB_RunQuery(ODS_SUPP_URL, ODS_User, ODS_SUPP_Pwd,Q_GDHODS_Account );
		TM_connectToDB_RunQuery(ODS_SUPP_URL, ODS_User, ODS_SUPP_Pwd,Q_GALIGN_Inactive );
		TM_connectToDB_RunQuery(ODS_SUPP_URL, ODS_User, ODS_SUPP_Pwd,Q_GALIGN_Auto );
		TM_connectToDB_RunQuery(ODS_SUPP_URL, ODS_User, ODS_SUPP_Pwd,Q_REPOSITOR );
		TM_connectToDB_RunQuery(ODS_SUPP_URL, ODS_User, ODS_SUPP_Pwd,Q_ETL_Employee );
		TM_connectToDB_RunQuery(ODS_SUPP_URL, ODS_User, ODS_SUPP_Pwd,Q_ETL_Deciles );
		TM_connectToDB_RunQuery(ODS_SUPP_URL, ODS_User, ODS_SUPP_Pwd,Q_DISTINCT );
	}
	@Test(priority = 4, enabled = false)
	public void ODS_S04_DB_SIT_GDHODS_Account() {
		TM_connectToDB_RunQuery(ODS_SIT_URL, ODS_User, ODS_SIT_Pwd,Q_GDHODS_Account );
		TM_connectToDB_RunQuery(ODS_SIT_URL, ODS_User, ODS_SIT_Pwd,Q_GALIGN_Inactive );
		TM_connectToDB_RunQuery(ODS_SIT_URL, ODS_User, ODS_SIT_Pwd,Q_GALIGN_Auto);
		TM_connectToDB_RunQuery(ODS_SIT_URL, ODS_User, ODS_SIT_Pwd,Q_REPOSITOR );
		TM_connectToDB_RunQuery(ODS_SIT_URL, ODS_User, ODS_SIT_Pwd,Q_ETL_Employee );
		TM_connectToDB_RunQuery(ODS_SIT_URL, ODS_User, ODS_SIT_Pwd,Q_ETL_Deciles );
		TM_connectToDB_RunQuery(ODS_SIT_URL, ODS_User, ODS_SIT_Pwd,Q_DISTINCT );
	}
	
	@Test(priority = 5, enabled = false)
	public void GDW_S05_DB_DEV_GDW() {
		TM_connectToDB_RunQuery(GDW_DEV_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSTG);
		TM_connectToDB_RunQuery(GDW_DEV_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_AGG);
		TM_connectToDB_RunQuery(GDW_DEV_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_SECURITY);
	}

	@Test(priority = 6, enabled = false)
	public void GDW_S06_DB_UAT_GDW() {
		TM_connectToDB_RunQuery(GDW_UAT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSTG);
		TM_connectToDB_RunQuery(GDW_UAT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_AGG);
		TM_connectToDB_RunQuery(GDW_UAT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_SECURITY);
	}
	@Test(priority = 7, enabled = false)
	public void GDW_S07_DB_SIT_GDW() {
		TM_connectToDB_RunQuery(GDW_SIT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSTG);
		TM_connectToDB_RunQuery(GDW_SIT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_AGG);
		TM_connectToDB_RunQuery(GDW_SIT_URL, GDW_User, GDW_DEV_UAT_SIT_Pwd,Q_GDWSMA_SECURITY);
	}
	@Test(priority = 8, enabled = false)
	public void GDW_S08_DB_SUPP_GDW() {
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


	void TM_connectToDB_RunQuery(String Url, String User, String Pass, String Query){
		try{
			// Get connection to DB
			Connection con = DriverManager.getConnection(Url, User, Pass);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(Query);
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			while (res.next()) {
				System.out.println("Count of records found : "+ res.getInt(1)+ " for Query:"+Query+ '\n' + "on this Database: " + Url + '\n');
				Reporter.log("Count of records found : "+ res.getInt(1)+ " for Query:"+Query+ '\n' + "on this Database: " + Url + '\n');
				Assert.assertTrue(res.getInt(1)>=0);

				/*
              System.out.print(res.getString(1));
              System.out.print("\t" + res.getString(2));
              System.out.print("\t" + res.getString(3));
              System.out.println("\t" + res.getString(4));
				 */
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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




}