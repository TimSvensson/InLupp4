JC=javac
CDIR=./class
JDIR=.
JFLAGS= -g
RM=rm -fr

FILES=Customer Register Queue Store Simulation Simulator
CLASSES=$(patsubst %,$(CDIR)/%.class,$(FILES))


$(CDIR)/%.class: $(JDIR)/%.java
	@echo "##\tMAKE\tCompiling " $*
	@$(JC) $(JFLAGS) -d $(CDIR) $^

default: $(CLASSES) clean

clean:
	@echo "##\tMAKE\tCleaning upp"
	@$(RM) *~

run: $(CDIR)/Simulator.class
	java -cp $(CDIR) Simulator.class
