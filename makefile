JC = javac
JRE = java

TARGET = TextAdventure

all: $(TARGET)

run:
	@$(JRE) $(TARGET)

$(TARGET):
	$(JC) $(TARGET).java

clean:
	@find . -type f -name '*.class' -exec rm {} +
