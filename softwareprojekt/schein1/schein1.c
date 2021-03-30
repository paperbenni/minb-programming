#include <stdio.h>

// Aufgabe 1
// laengstes suffix ohne 2 :

char *targetstring;
char userinput[100];

int main(int argc, char *argv[])
{
    int i;
    int position;
    if (argc >= 2) {
        targetstring = argv[1];
    } else {
        printf("enter string (please)> ");
        fgets(userinput, sizeof(userinput), stdin);
        targetstring = userinput;
    }

    for (i = 0; targetstring[i] != '\0'; ++i) {
        if (*(targetstring + i) == ':' && *(targetstring + i + 1) == ':') {
            position = i + 2;
        }
    }
    printf("%s\n", targetstring + position);
    return 0;
}
