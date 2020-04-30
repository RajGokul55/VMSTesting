$cred = get-Credential -credential administrator 
 $computer = get-content C:\Users\bpalle\git\SeleniumAutomationV0.1\AutoFiles\computers.txt
 Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq "wuauserv" } | Out-File -FilePath C:\Users\bpalle\git\SeleniumAutomationV0.1\AutoFiles\Output.txt