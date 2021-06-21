CXXFLAGS+= --std=c++11

build: testParser

testParser : testParser.o parser.o tokenizer.o ast.o
	$(CXX) $(CXXFLAGS) testParser.o parser.o tokenizer.o ast.o -o testParser

testParser.o: testParser.cpp

testVm : testVm.o vm.o testParser.o parser.o tokenizer.o ast.o
	$(CXX) $(CXXFLAGS) testVm.o vm.o parser.o tokenizer.o ast.o -o testVM

testVm.o: testVm.cpp

ast.o: ast.cpp ast.h

tokenizer.o: tokenizer.cpp tokenizer.h

parser.o: parser.cpp parser.h ast.h tokenizer.h utility.h

vm.o: vm.cpp vm.h

clean:
	$(RM) *.o testParser testVm
