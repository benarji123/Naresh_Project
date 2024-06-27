set ProjectPath=C:\AssetCreation
cd %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\libs\*
java org.testng.TestNG %ProjectPath%\testng.xml
pause