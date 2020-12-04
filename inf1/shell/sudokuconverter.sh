#!/bin/bash

# accepts sudokus of the following format

# 003020600
# 900305001
# 001806400
# 008102900
# 700000008
# 006708200
# 002609500
# 800203009
# 005010300

# outputs an array like format

sed 's/\(.\)/\1, /g' "${1:-sudoku.txt}" | sed 's/..$/}, /g' | sed 's/^/{/g'
