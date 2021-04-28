/*
 * Aufgabe 1.c
 *
 *  Created on: 26.04.2021
 */

#include <stdio.h>

#define TEST_CASES_COUNT 9 // Anzahl der Tests

typedef struct {
  char *input;
  char *expected;
} TestCase;

// Aufgabe 1
// laengstes suffix ohne ::

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

void extract2(char *input, char **output) { *output = extract(input); }

typedef enum { OK, FAIL } Test;

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

void runTests(int no, TestCase test[]) {
  Test t;
  int i;

  for (i = 0; i < no; i++) {
    printf("Test %d: ", i);
    t = testColonparser(test[i].input, test[i].expected);
    if (OK == t)
      printf("OK   input:    %-30s function output: %s\n", test[i].input,
             test[i].expected);
    if (FAIL == t)
      printf("FAIL expected: %-30s function output %s \n", test[i].expected,
             extract(test[i].input));
  }
}

int main(int argc, char *argv[]) {
  TestCase tests[TEST_CASES_COUNT] = {
      {"aaaa::bbb", "bbb"},
      {"aaaa::bbb::g", "g"},
      {"hello::world:", "world:"},
      {"::hello_world", "hello_world"},
      {"hello_world::", ""},
      {"aaaaaaa::aaaaaaaaaaa::aaaaaa", "aaaaaa"},
      {"this:is:a::test", "test"},
      {"this:: tests :: s p a c e s", " s p a c e s"},
      {"no double colon here", "no double colon here"},
  };

  runTests(TEST_CASES_COUNT, tests);
}
