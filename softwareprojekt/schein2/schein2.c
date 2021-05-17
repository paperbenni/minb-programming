#include <stdio.h>
#include <stdlib.h>

char *reverseRec(char *s);
char *reverse(char *s);

int length(char *s) {
  int n = 0;
  while (*s != '\0') {
    n++;
    s++;
  }

  return n;
}

char *reverse(char *s) {
  int i;
  int len = length(s);
  char tmp;
  char *out = malloc(len * (sizeof(char) + 1));
  for (i = 0; i < len; ++i) {
    out[i] = s[len - i - 1];
  }
  return out;
}

// Annahme: n ist > 0
void copy(char *s, int n, char *t) {
  int i = 0;
  while (i < n) {
    t[i] = s[i];
    i++;
  }
}

char *putBack(char *s, char c) {
  const int n = length(s);
  char *r = malloc(sizeof(char) * (n + 2));
  copy(s, n, r);
  r[n] = c;
  r[n + 1] = '\0';
  return r;
}

char *reverseRec(char *s) {
  int len = length(s);
  char *tester;
  char *tester2;
  char *frank;
  if (len == 0) {
      char *rawstring = malloc(sizeof(char));
      rawstring[0] = '\0';
      return rawstring;
  } else {
    tester = reverseRec(s + 1);
    tester2 = putBack(tester, s[0]);
    free(tester);
    return tester2;
  }
}

int main(int argc, char *argv[]) {
  char *teststring;
  teststring = reverse("Hello World!");
  printf("%s\n", teststring);
  free(teststring);
  teststring = reverseRec("Hello World!");
  printf("%s\n", teststring);
  free(teststring);
  return 0;
}
