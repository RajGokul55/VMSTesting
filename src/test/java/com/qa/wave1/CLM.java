package com.qa.wave1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class CLM extends CommonMethods {

	/***************************** Test Data ************************************/

	static final String userDirectory = System.getProperty("user.dir");

	String path = userDirectory + "\\AutoFiles\\";
	String resout = path + "Output.txt";
	String runbat = path + "Run.bat";
	String ADM_UserID = null;
	String password = null;

	/***************************** Test ************************************/
	@BeforeMethod(enabled = true)
	public void BeforeRunningTest() {

		ADM_UserID = "ADM_nnereddula";
		//password = RSA_Authentication("bpalle"); //
		password = "hGj!s7knO?hU"; 

	}

	@Test(priority = 0, enabled = false) // Access Denied
	public void CLM_S01_WinSrve_EOCONAPPPRDN02() {
		TM_CLM_S01_WinSrve_EOCONAPPPRDN02();
	}

	@Test(priority = 1, enabled = true)
	public void CLM_S02_WinSrve_SJCLMAPPPRDN01() {
		TM_CLM_S02_WinSrve_SJCLMAPPPRDN01();
	}

	@Test(priority = 2, enabled = false)
	public void CLM_S03_WinSrve_SJCONAPPPRDN02() {
		TM_CLM_S03_WinSrve_SJCONAPPPRDN02();
	}

	@Test(priority = 3, enabled = false)
	public void CLM_S04_WinSrve_SJCONAPPPRDN03() {
		TM_CLM_S04_WinSrve_SJCONAPPPRDN03();
	}

	@Test(priority = 4, enabled = false)
	public void CLM_S05_WinSrve_SJCONAPPPRDN13() {
		TM_CLM_S05_WinSrve_SJCONAPPPRDN13();
	}

	@Test(priority = 5, enabled = false)
	public void CLM_S06_WinSrve_CCCONAPPPRDN01() {
		TM_CLM_S06_WinSrve_CCCONAPPPRDN01();
	}

	@Test(priority = 6, enabled = false) // Access Denied
	public void CLM_S07_WinSrve_HGCONAPPPRDN02() {
		TM_CLM_S07_WinSrve_HGCONAPPPRDN02();
	}

	@Test(priority = 7, enabled = true)
	public void CLM_S08_WinSrve_LDCONAPPPRDN01() {
		TM_CLM_S08_WinSrve_LDCONAPPPRDN01();
	}

	@Test(priority = 8, enabled = false)
	public void CLM_S09_WinSrve_FCCONAPPPRDN01() {
		TM_CLM_S09_WinSrve_FCCONAPPPRDN01();
		TM_CLM_S09_WinSrve_FCCONAPPPRDN01Extn();
	}

	@Test(priority = 9, enabled = false)
	public void CLM_S10_WinSrve_SJCONAPPPRDN01() {
		TM_CLM_S10_WinSrve_SJCONAPPPRDN01();
	}

	@Test(priority = 10, enabled = false)
	public void CLM_S11_WinSrve_SECONAPPPRDN02() {
		TM_CLM_S11_WinSrve_SECONAPPPRDN02();
	}

	@Test(priority = 11, enabled = false)
	public void CLM_S12_WinSrve_LDCONAPPPRDN02() {
		TM_CLM_S12_WinSrve_LDCONAPPPRDN02();
	}



	/***************************** * Test Methods	 ************************************/
	void TM_CLM_S01_WinSrve_EOCONAPPPRDN02() {
		createPS1HostnameServices(ADM_UserID, password, "EOCONAPPPRDN02", "arc_sjna2_dns_tracelog , arc_sjna2_wuc, arc_sjna2_wuc2");	
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_sjna2_dns_tracelog", "Stopped");
		verifyServiceStatus(resout, "arc_sjna2_wuc", "Running");
		verifyServiceStatus(resout, "arc_sjna2_wuc2", "Running");
	}

	void TM_CLM_S02_WinSrve_SJCLMAPPPRDN01() {
		createPS1HostnameServices(ADM_UserID, password, "SJCLMAPPPRDN01", "arc_wef_winc");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_wef_winc", "Running");
	}

	void TM_CLM_S03_WinSrve_SJCONAPPPRDN02() {
		createPS1HostnameServices(ADM_UserID, password, "SJCONAPPPRDN02", "arc_druva_insync_flexfolder, arc_sdkfolderreader___CSV_ShareFile, arc_sjna2_dns_tracelog, arc_sjna2_wuc, arc_sjna2_Pulse_Secure_syslog_8514, arc_sjna2_Radiant");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_druva_insync_flexfolder", "Running");
		verifyServiceStatus(resout, "arc_sdkfolderreader___CSV_ShareFile", "Running");
		verifyServiceStatus(resout, "arc_sjna2_dns_tracelog", "Running");
		verifyServiceStatus(resout, "arc_sjna2_wuc", "Running");
		verifyServiceStatus(resout, "arc_sjna2_Pulse_Secure_syslog_8514", "Running");
		verifyServiceStatus(resout, "arc_sjna2_Radiant", "Running");
	}

	void TM_CLM_S04_WinSrve_SJCONAPPPRDN03() {
		createPS1HostnameServices(ADM_UserID, password, "SJCONAPPPRDN03", "arc_AZURE_Portal_1999_v7_13,arc_exchange_message_tracking_log_multiple_server_file, arc_exchange_message_tracking_log_multiple_server_file2 ");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_AZURE_Portal_1999_v7_13", "Running");
		verifyServiceStatus(resout, "arc_exchange_message_tracking_log_multiple_server_file", "Running");
		verifyServiceStatus(resout, "arc_exchange_message_tracking_log_multiple_server_file2", "Running");
	}

	void TM_CLM_S05_WinSrve_SJCONAPPPRDN13() {
		createPS1HostnameServices(ADM_UserID, password, "SJCONAPPPRDN13", "arc_sdkmultifolderreader, arc_Service_Now_syslog, arc_SJ_Symantec_DLP_EU_Syslog, arc_SJ_Symantec_DLP_NA_syslog, arc_syslog_Attivo");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_sdkmultifolderreader", "Running");
		verifyServiceStatus(resout, "arc_Service_Now_syslog", "Running");
		verifyServiceStatus(resout, "arc_SJ_Symantec_DLP_EU_Syslog", "Running");
		verifyServiceStatus(resout, "arc_SJ_Symantec_DLP_NA_syslog", "Running");
		verifyServiceStatus(resout, "arc_syslog_Attivo", "Running");
	}

	void TM_CLM_S06_WinSrve_CCCONAPPPRDN01() {
		createPS1HostnameServices(ADM_UserID, password, "CCCONAPPPRDN01", "arc_cceu_ad_wuc_QualGMPCC, arc_cceu_asafwl_syslog ");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_cceu_ad_wuc_QualGMPCC", "Running");
		verifyServiceStatus(resout, "arc_cceu_asafwl_syslog", "Running");	
	}
	void TM_CLM_S07_WinSrve_HGCONAPPPRDN02() {
		createPS1HostnameServices(ADM_UserID, password, "HGCONAPPPRDN02", "arc_bluecoat_ng_file, arc_hgap_bluecoat_file_to_netskope");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_bluecoat_ng_file", "Running");
		verifyServiceStatus(resout, "arc_hgap_bluecoat_file_to_netskope", "Running");
	}

	void TM_CLM_S08_WinSrve_LDCONAPPPRDN01() {
		createPS1HostnameServices(ADM_UserID, password, "LDCONAPPPRDN01", "arc_bluecoat_ng_file,arc_ldeu_dns_tracelog, arc_ldeu_dns_tracelog2,arc_ldeu_ad_wuc, arc_ldeu_ad_wuc2");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_bluecoat_ng_file", "Running");
		verifyServiceStatus(resout, "arc_ldeu_dns_tracelog", "Running");
		verifyServiceStatus(resout, "arc_ldeu_dns_tracelog2", "Running");
		verifyServiceStatus(resout, "arc_ldeu_ad_wuc", "Running");
		verifyServiceStatus(resout, "arc_ldeu_ad_wuc2", "Running");	
	}

	void TM_CLM_S09_WinSrve_FCCONAPPPRDN01() {
		createPS1HostnameServices(ADM_UserID, password, "FCCONAPPPRDN01", "arc_dc_list_filereader,arc_fcna_dhcp_file,arc_isa_multiserver_file,arc_avatier_iis_multiserver,arc_fcna_dns_tracelog,arc_fcna_dns_tracelog2");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_dc_list_filereader", "Running");
		verifyServiceStatus(resout, "arc_fcna_dhcp_file", "Running");
		verifyServiceStatus(resout, "arc_isa_multiserver_file", "Running");
		verifyServiceStatus(resout, "arc_avatier_iis_multiserver", "Running");
		verifyServiceStatus(resout, "arc_fcna_dns_tracelog", "Running");
		verifyServiceStatus(resout, "arc_fcna_dns_tracelog2", "Running");
	}
	void TM_CLM_S09_WinSrve_FCCONAPPPRDN01Extn() {
		createPS1HostnameServices(ADM_UserID, password, "FCCONAPPPRDN01", "arc_fcna_ad_wuc,arc_fcna_ad_wuc2,arc_fcna_adfs_wuc,arc_quest_ars_wuc,arc_Sep_DCS_Prod,arc_symantecendpointprotection_db,arc_symantecendpointprotection14_db");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_fcna_ad_wuc", "Running");
		verifyServiceStatus(resout, "arc_fcna_ad_wuc2", "Running");
		verifyServiceStatus(resout, "arc_fcna_adfs_wuc", "Running");
		verifyServiceStatus(resout, "arc_quest_ars_wuc", "Running");
		verifyServiceStatus(resout, "arc_Sep_DCS_Prod", "Running");
		verifyServiceStatus(resout, "arc_symantecendpointprotection_db", "Running");
		verifyServiceStatus(resout, "arc_symantecendpointprotection14_db", "Running");
	}
	void TM_CLM_S10_WinSrve_SJCONAPPPRDN01() {
		createPS1HostnameServices(ADM_UserID, password, "SJCONAPPPRDN01", "arc_sjna_dns_tracelog,arc_sjna_dns_tracelog2,arc_sjna_ad_wuc,arc_sjna_ad_wuc2,arc_sjna_fireeye_syslog,arc_sjna_ciscoasa_fw_syslog,arc_sjna_bit9_carbonblack_syslog");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_sjna_dns_tracelog", "Running");
		verifyServiceStatus(resout, "arc_sjna_dns_tracelog2", "Running");
		verifyServiceStatus(resout, "arc_sjna_ad_wuc", "Running");
		verifyServiceStatus(resout, "arc_sjna_ad_wuc2", "Running");
		verifyServiceStatus(resout, "arc_sjna_fireeye_syslog", "Running");
		verifyServiceStatus(resout, "arc_sjna_ciscoasa_fw_syslog", "Running");
		verifyServiceStatus(resout, "arc_sjna_bit9_carbonblack_syslog", "Running");
	}

	void TM_CLM_S11_WinSrve_SECONAPPPRDN02() {
		createPS1HostnameServices(ADM_UserID, password, "SECONAPPPRDN02", "arc_sena2_dns_tracelog, arc_winc");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_sena2_dns_tracelog", "Running");
		verifyServiceStatus(resout, "arc_winc", "Running");
	}

	void TM_CLM_S12_WinSrve_LDCONAPPPRDN02() {
		createPS1HostnameServices(ADM_UserID, password, "LDCONAPPPRDN02", "arc_ldeu2_dns_tracelog,arc_ldeu2_ad_wuc,arc_ldeu2_ad_wuc2");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_ldeu2_dns_tracelog", "Running");
		verifyServiceStatus(resout, "arc_ldeu2_ad_wuc", "Running");
		verifyServiceStatus(resout, "arc_ldeu2_ad_wuc2", "Running");
	}

}
