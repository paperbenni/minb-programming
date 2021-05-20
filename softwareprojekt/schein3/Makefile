all: build

schein3: main.cpp String.cpp
	g++ -o schein3 -g String.cpp main.cpp 

run: schein3
	./schein3

debug: schein3
	gdb schein3
