// String.cpp
#include <iostream>
using namespace std;

#include "String.h"

String::String() {
  size = 0;
  str = new char[1];
  str[0] = '\0';
}

void copy(char *s, int n, char *t) {
  int i = 0;
  while (i < n) {
    t[i] = s[i];
    i++;
  }
}

String::String(char c) {
  size = 1;
  str = new char[2];
  str[0] = c;
  str[1] = '\0';
}

// copy
// literal init

String::String(const char *s) {
  int i = 0;
  int length = 0;
  size = 0;
  while (s[i] != '\0') {
    i++;
  }

  size = i;
  i = 0;

  str = new char[size];

  while (s[i] != '\0') {
    str[i] = s[i];
    i++;
  }
}

// copy
// done
String::String(const String &s) {
  this->size = s.size;
  this->str = new char[s.size];
  copy(s.str, s.size, this->str);
}

// move
String::String(String &&s) {
  this->size = s.size;
  /* delete[] this->str; */
  this->str = s.str;
  s.str = nullptr;
}

// destructor
String::~String() { delete[] str; }

char &String::operator[](int index) { return this->str[index]; }

// copy
String &String::operator=(const String &s) {
  this->size = s.size;
  this->str = new char[s.size];
  copy(s.str, s.size, this->str);
  return *this;
}

// move
String &String::operator=(String &&s) {
    if (this->size > 0)
      delete[] this->str;
  this->size = s.size;
  this->str = s.str;
  s.str = nullptr;
  return *this;
}

// append
// done
String &String::operator+=(String &s) {
  int newsize = s.size + this->size;
  char *tmp = new char[newsize];
  int i;

  i = 0;
  while (i < newsize) {
    if (i < this->size) {
      tmp[i] = this->str[i];
    } else {
      tmp[i] = s.str[i - this->size];
    }
    i++;
  }

  this->size = newsize;
  delete[] this->str;
  this->str = tmp;
  return *this;
}
