#include "String.h"

ostream& operator<< (ostream &out, String &s) {
  for(int i=0; i<s.size; i++) {
    out << s.str[i];
  }
  return out;
}


int main() {
  String s;
  String s2('H');
  String s3("Hello World!");

  cout << s << endl;
  cout << s2 << endl;
  cout << s3 << endl;

}
