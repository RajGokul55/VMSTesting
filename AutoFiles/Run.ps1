$Username = 'NA\ADM_nnereddula' 
$Password = ConvertTo-SecureString 'Ftr%@4Wp%8El' -AsPlainText -Force 
$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)
$computer = 'SECONAPPPRDN02' 
$servename1 = 'arc_sena2_dns_tracelog' 
$servename2 = 'arc_winc' 
Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 } | Out-File -FilePath C:\Users\bpalle\git\SeleniumAutomationV0.1\AutoFiles\Output.txt
PAUSE