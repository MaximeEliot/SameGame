### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none -d CLS -cp CLS
SRC= ./SRC/
CLS= ./CLS/

JVM = java
JVMFLAGS = -cp CLS

### REGLES ESSENTIELLES ###

${CLS}Main.class : ${SRC}Main.java ${CLS}Menu.class
	${JC} ${JCFLAGS} ${SRC}Main.java 

${CLS}MenuListener.class : ${SRC}MenuListener.java ${CLS}Choix.class
	${JC} ${JCFLAGS} ${SRC}MenuListener.java 

${CLS}Choix.class : ${SRC}Choix.java
	${JC} ${JCFLAGS} ${SRC}Choix.java

${CLS}MenuFin.class ${CLS}Menu.class ${CLS}AfficheJeu.class :${SRC}MenuFin.java ${SRC}Menu.java ${SRC}AfficheJeu.java ${CLS}MenuFinListener.class ${CLS}MenuListener.class ${CLS}PartieListener.class ${CLS}Partie.class
	${JC} ${JCFLAGS} ${SRC}MenuFin.java ${SRC}Menu.java ${SRC}AfficheJeu.java

${CLS}MenuFinListener.class : ${SRC}MenuFinListener.java 
	${JC} ${JCFLAGS} ${SRC}MenuFinListener.java


${CLS}Partie.class :${SRC}Partie.java ${CLS}Rearange.class
	${JC} ${JCFLAGS} ${SRC}Partie.java

${CLS}PartieListener.class :
	${JC} ${JCFLAGS} ${SRC}PartieListener.java

${CLS}Rearange.class :
	${JC} ${JCFLAGS} ${SRC}Rearange.java
### REGLES OPTIONNELLES ###

run : ${CLS}Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f ${CLS}*.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###