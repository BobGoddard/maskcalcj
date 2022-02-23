A simple netmask, network, broadcast & subnet calculator.<BR>
<img src="maskcalc_window-bin.png" alt="maskcalc window bin"/>
<img src="maskcalc_window-oct.png" alt="maskcalc window oct"/>
<img src="maskcalc_window-dec.png" alt="maskcalc window dec"/>
<img src="maskcalc_window-hex.png" alt="maskcalc window hex"/>

To build and run...
1. CD into the src directory
2. javac -Xdiags:verbose maskcalc/*.java
3. jar -c -f maskcalc.jar -v -m MANIFEST.MF maskcalc/*.class maskcalc.png
4. java -jar maskcalc.jar
