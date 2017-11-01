# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: testBallsSimulator testGridConwaySimulator 

testBoids:
	javac -d bin -sourcepath src src/TestBoids.java

testVacants:
	javac -d bin -sourcepath src src/TestVacants.java
	
testBoidsSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBoidsSimulator.java
	
testBallsSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBallsSimulator.java

testGridConwaySimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGridConwaySimulator.java

testGridnSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGridnSimulator.java

testSchellingSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestSchellingSimulator.java

testEventManager:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestEventManager.java
# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM


exeBallsSimulator:
	java -classpath bin:bin/gui.jar TestBallsSimulator

exeGridConwaySimulator:
	java -classpath bin:bin/gui.jar TestGridConwaySimulator

exeGridnSimulator:
	java -classpath bin:bin/gui.jar TestGridnSimulator

exeSchellingSimulator:
	java -classpath bin:bin/gui.jar TestSchellingSimulator

exeBoidsSimulator:
	java -classpath bin:bin/gui.jar TestBoidsSimulator

exeEventManager:
	java -classpath bin:bin/gui.jar TestEventManager

exeBoids:
	java -classpath bin TestBoids
exeVacants:
	java -classpath bin TestVacants

clean:
	rm -rf bin/*.class
