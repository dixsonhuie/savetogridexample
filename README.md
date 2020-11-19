# savetogridexample


  * Go to 'IE install directory'/bin; run gs.sh demo
  * Go to 'savetogridexample project directory'
  * Use `mvn package` to create the uber jar needed for spark submit
  * Go to 'savetogridexample project directory'/target/classes/bin
  * Verify the script. Check if the directory locations are correct.
  * To insert into the grid run: `bash savetogrid.sh`
  * To read from the grid run: `bash readfromgrid.sh`
