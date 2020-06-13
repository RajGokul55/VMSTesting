package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class CLM_Stand1 extends CommonMethods {


	@Test(enabled = true, priority =1, groups = "Prod")
	public void CLM_CCCONAPPPRDN01() {
		verifyWinSerStatus("CCCONAPPPRDN01", "Arcsight cceu_ad_wuc_QualGMPCC", "Running", "Auto");
		verifyWinSerStatus("CCCONAPPPRDN01", "Arcsight cceu_asafwl_syslog", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2,groups = "Prod")
	public void CLM_EOCONAPPPRDN02() {
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =3,groups = "Prod")
	public void CLM_FCCONAPPPRDN01() {
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight arcsight Flexconnector DC file reader", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "arcsight microsoft DHCP file", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Forefront Threat Management Gateway File", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft IIS Multiple Server File - Avatier", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight Microsoft DNS trace log multiple server file", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight Microsoft DNS trace log multiple server file2", "Running", "Auto");verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - ADFS", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - ARS", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight sep_DCS_Prod", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Symantec Endpoint Protection DB", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Symantec Endpoint Protection 14 DB", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =4,groups = "Prod")
	public void CLM_HGCONAPPPRDN02() {
		verifyWinSerStatus("HGCONAPPPRDN02", "ArcSight Blue Coat Proxy SG Multiple Server File", "Running", "Auto");
		verifyWinSerStatus("HGCONAPPPRDN02", "ArcSight Blue Coat Proxy SG Multiple Server File to Netskope", "Running", "Auto");
			}
	
	@Test(enabled = true, priority =5,groups = "Prod")
	public void CLM_LDCONAPPPRDN01() {
		verifyWinSerStatus("LDCONAPPPRDN01", "Arcsight blue coat proxy SG multiple server file", "Running", "Auto");
		verifyWinSerStatus("LDCONAPPPRDN01", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
		verifyWinSerStatus("LDCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("LDCONAPPPRDN01", "ArcSight Microsoft DNS Trace Log Multiple Server File2", "Running", "Auto");
		verifyWinSerStatus("LDCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =6,groups = "Prod")
	public void CLM_SJCLMAPPPRDN01() {
		verifyWinSerStatus("SJCLMAPPPRDN01", "ArcSight Microsoft Windows Event Log - Native", "Running", "Auto");
	}

	@Test(enabled = true, priority =7,groups = "Prod")
	public void CLM_SJCONAPPPRDN01() {
		verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight fireeye syslog daemon", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN01", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN01", "ArcSight Microsoft DNS Trace Log Multiple Server File2", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight cisco ASA FW syslog daemon", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN01", "ArcSight Bit9+Carbon Black Syslog Daemon", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =8,groups = "Prod")
	public void CLM_SJCONAPPPRDN02() {
		verifyWinSerStatus("SJCONAPPPRDN02", "ArcSight ArcSight FlexConnector Multiple Folder File - Druva InSync", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN02", "ArcSight ArcSight FlexConnector Regex Folder File - CSV_ShareFile", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN02", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN02", "ArcSight sjna2_Pulse_Secure syslog 8514", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN02", "Arcsight syslog daemon", "Running", "Auto");
		
	}
	
	@Test(enabled = true, priority =9,groups = "Prod")
	public void CLM_SJCONAPPPRDN03() {
		verifyWinSerStatus("SJCONAPPPRDN03", "Arcsight AZURE_Portal_1999_v7_13", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN03", "Arcsight microsoft exchange message tracking log multiple server file2", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN03", "Arcsight microsoft exchange message tracking log multiple server file", "Running", "Auto");
		
	}
	
	@Test(enabled = true, priority =10,groups = "Prod")
	public void CLM_SJCONAPPPRDN13() {
		verifyWinSerStatus("SJCONAPPPRDN13", "ArcSight ArcSight FlexConnector Multiple Folder File-PingFederate", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN13", "ArcSight Service-Now_Syslog Daemon", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight SJ_symantec_DLP_EU_syslog", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight SJ_symantec_DLP_NA_syslog", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight syslog daemon_attivo", "Running", "Auto");
	}
	
}