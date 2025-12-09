JAVAC = javac
JAVA  = java
SRC_DIR = src
OUT_DIR = out
MAIN_CLASS = app.main.Main

SOURCES := $(shell find $(SRC_DIR) -name "*.java")

all: compile

compile:
	mkdir -p $(OUT_DIR)
	$(JAVAC) -d $(OUT_DIR) $(SOURCES)

run: compile
	$(JAVA) -cp $(OUT_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR)
