// String.cpp
#include <iostream>
using namespace std;

#include "String.h"


String::String() { 
    size = 0;
    str = new char[1];
    str[0] = '\0';
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

// move
String::String(const String& s) {
  // TODO
}

// ??
String::String(String&& s) {
  // TODO
}

// destructor
String::~String() { delete[] str; }

char& String::operator[](int index) {
  // TODO
}

// copy
String& String::operator=(const String& s) {
  // TODO
}

// move
String& String::operator=(String&& s) {
  // TODO
}

// append
String& String::operator+=(String& s) {
  // TODO
}

