// AST for exp


#ifndef __AST__
#define __AST__

#include <iostream>
#include <string>
#include <memory>

using namespace std; 

enum ExpType { Plus, Mult , Int};

class Exp {

    public:
      ExpType t;  
      virtual int eval() = 0;
      virtual string pretty() = 0;
      virtual string smartpretty() = 0;
      ExpType getType() {
          return t;
      }

};

class IntExp : public Exp {
  int val;
  public:
  IntExp(int _val) { val = _val; t = Int;}
  int eval();
  string pretty();
  string smartpretty();
};

class PlusExp : public Exp {
  std::shared_ptr<Exp> e1;
  std::shared_ptr<Exp> e2;
  bool klammered = false;
  public:
  PlusExp(std::shared_ptr<Exp> _e1, std::shared_ptr<Exp> _e2) {
      e1 = _e1; e2 = _e2;
      t = Plus;
  }
  int eval();
  string pretty();
  string smartpretty();
};


class MultExp : public Exp {
  std::shared_ptr<Exp> e1;
  std::shared_ptr<Exp> e2;
  public:
  MultExp(std::shared_ptr <Exp> _e1, std::shared_ptr<Exp> _e2) {
      e1 = _e1; e2 = _e2;
      t = Mult;
  }
  int eval();
  string pretty();
  string smartpretty();
};

// Short-hands

typedef std::shared_ptr<Exp> EXP;

EXP newInt(int i);

EXP newPlus(EXP l, EXP r);

EXP newMult(EXP l, EXP r);


#endif // __AST__
