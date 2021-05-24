#include "String.h"

ostream &operator<<(ostream &out, String &s) {
  for (int i = 0; i < s.size; i++) {
    out << s.str[i];
  }
  return out;
}

int main() {

  String s1;
  String s2("Hello");
  String s3(s2);
  s1 += s2;
  s2 = s3;
  cout << s2 << endl;
  cout << s2[2] << endl;
}
