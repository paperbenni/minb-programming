
#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;


#include "parser.h"
#include "ast.h"



void display(Optional<EXP> e) {
  if(e.isNothing()) {
    cout << "nothing \n";
  } else {
    cout << (e.fromJust())->pretty() << "\n";
  }
  return;
}

void smartdisplay(Optional<EXP> e) {
  if(e.isNothing()) {
    cout << "nothing \n";
  } else {
    cout << (e.fromJust())->smartpretty() << "\n";
  }
  return;
}


void testParserGood() {

  display(Parser("1").parse());
  smartdisplay(Parser("1").parse());
  cout << endl;

  display(Parser("1 + 0 ").parse());
  smartdisplay(Parser("1 + 0 ").parse());
  cout << endl;

  display(Parser("1 + (0) ").parse());
  smartdisplay(Parser("1 + (0) ").parse());
  cout << endl;

  display(Parser("1 + 2 * 0 ").parse());
  smartdisplay(Parser("1 + 2 * 0 ").parse());
  cout << endl;

  display(Parser("1 * 2 + 0 ").parse());
  smartdisplay(Parser("1 * 2 + 0 ").parse());
  cout << endl;

  display(Parser("(1* ( 1 + 2) * 0 )").parse());
  smartdisplay(Parser("(1* ( 1 + 2) * 0 )").parse());
  cout << endl;

  display(Parser("(1 + 2) * 0 + 2").parse());
  smartdisplay(Parser("(1 + 2) * 0 + 2").parse());
}

void testTerm(string term) {
    bool failed = false;
    auto testterm = Parser(term).parse();
    cout << "Testing term " << term << " ";
    string normalstr = (testterm.fromJust())->pretty();
    string smartstr = (testterm.fromJust())->smartpretty();
    
    string teststr = (Parser(smartstr).parse().fromJust())->pretty();
    
    // test if both pretty terms evaluate to the same
    if (!(
                Parser(normalstr).parse().fromJust()->eval() == 
                Parser(smartstr).parse().fromJust()->eval()
         )) {
        failed = true;
    }

    // catch coincidences where terms are different but have the same eval value
    if (teststr.compare(normalstr) != 0) {
        failed = true;
    }

    if (failed) {
        cout << "| FAILED" << endl;
    } else {
        cout << "| OK" << endl;
    }

}

void testParser() {

  cout << "displaying terms" << endl;
  testParserGood();
  cout << endl;

  testTerm("1 + 0 ");
  testTerm("1 + (0) ");
  testTerm("1 + 2 * 0 ");
  testTerm("1 * 2 + 0 ");
  testTerm("(1* ( 1 + 2) * 0 )");
  testTerm("(1 + 2) * 0 + 2");

}


int main() {

    testParser();

  return 1;
}
