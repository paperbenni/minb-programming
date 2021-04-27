#include <stdio.h>

// Aufgabe 1
// laengstes suffix ohne 2 :

char *targetstring;
char userinput[100];

typedef enum { OK, FAIL } Test;

// extract nach beispielen
char *extract(char *input) {
  int i;
  int position;

  for (i = 0; input[i] != '\0'; ++i) {
    if (*(input + i) == ':' && *(input + i + 1) == ':') {
      position = i + 2;
    }
  }
  return input + position;
}

int stringcompare(char *a, char *b) {
  int i;
  int ret = 0;
  i = 0;
  while (*a || *b) {
    if (*a != *b) {
      ret = 1;
      break;
    }
    a++;
    b++;
  }
  return ret;
}

Test testColonparser(char *input, char *expected) {
  Test t;
  if (stringcompare(extract(input), expected) == 0)
    t = OK;
  else
    t = FAIL;
  return t;
}

typedef struct {
  char *input;
  char *expected;
} TestCase;

void runTests(int no, TestCase test[]) {
  Test t;
  int i;

  for (i = 0; i < no; i++) {
    printf("Test %d: ", i);
    t = testColonparser(test[i].input, test[i].expected);
    if (OK == t)
      printf("OK \n");
    if (FAIL == t)
      printf("FAIL \n");
  }
}

int main(int argc, char *argv[]) {
  const int testNo = 8;
  TestCase tests[8] = {
      {"aaaa::bbb", "bbb"},
      {"aaaa::bbb::g", "g"},
      {"hello::world:", "world:"},
      {"::hello_world", "hello_world"},
      {"hello_world::", ""},
      {"aaaaaaa::aaaaaaaaaaa::aaaaaa", "aaaaaa"},
      {"this:is:a::test", "test"},
      {"I::don't think there are a lot more ::special cases to cover",
       "special cases to cover"},
  };

  runTests(testNo, tests);
}
