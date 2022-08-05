echo "#################################################################################################"

echo -e "\n" > results.txt

echo "#################################################################################################"

echo "C++ started"
reqArray=("[]" "strcmp" "sprintf" "isalpha" "isxdigit" "isdigit" ".replace" ".substr" "stof" "stoi" "tolower" "toupper")
for str in ${reqArray[@]}; do
  INPUT=$(curl --location --request GET "https://api.github.com/search/code?q=$str+in:file+language:c++" --header 'Authorization: Token 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')
  echo ${str}
  echo answer_length ${#INPUT}
  sub1=${INPUT#*:} 
  sub2=${INPUT#*,}
  left=$((${#INPUT} - ${#sub1} + 1)) # ok
  right=$((${#INPUT} - ${#sub2}))
  length=$(($right - $left - 1))
  result=${INPUT:${left}:${length}} 
  echo $str $result >> results.txt
  sleep 61
done
echo "C++ finished"

echo "#################################################################################################"

echo "Java started"
reqArray=(".charAt" "compareTo" ".concat" ".endsWith" "format" ".isHexDigit" ".isLowerCase" ".isUpperCase" ".isBlank" ".join" ".matches" ".repeat" ".replaceAll" ".split" "startsWith" ".strip" "substring" "valueOf" ".toLowerCase" ".toUpperCase" ".stripLeading" ".stripTrailing")
for str in ${reqArray[@]}; do
  INPUT=$(curl --location --request GET "https://api.github.com/search/code?q=$str+in:file+language:java" --header 'Authorization: Token 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')
  echo ${str}
  echo answer_length ${#INPUT}
  sub1=${INPUT#*:} 
  sub2=${INPUT#*,}
  left=$((${#INPUT} - ${#sub1} + 1)) # ok
  right=$((${#INPUT} - ${#sub2}))
  length=$(($right - $left - 1))
  result=${INPUT:${left}:${length}} 
  echo $str $result >> results.txt
  sleep 61
done
echo "Java finished"

echo "#################################################################################################"

echo "Python started"
reqArray=("[]" ".endswith" ".format" ".isalpha" ".isdigit" ".islower" ".isupper" ".isspace" ".join" "re.match" ".partition" ".replace" ".split" ".startswith" ".strip" ".slices" ".swapcase" ".lower" ".upper" ".lstrip" ".rstrip")
for str in ${reqArray[@]}; do
  INPUT=$(curl --location --request GET "https://api.github.com/search/code?q=$str+in:file+language:python" --header 'Authorization: Token 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')
  echo ${str}
  echo answer_length ${#INPUT}
  sub1=${INPUT#*:} 
  sub2=${INPUT#*,}
  left=$((${#INPUT} - ${#sub1} + 1)) # ok
  right=$((${#INPUT} - ${#sub2}))
  length=$(($right - $left - 1))
  result=${INPUT:${left}:${length}} 
  echo $str $result >> results.txt
  sleep 61
done
echo "Python finished"

echo "#################################################################################################"

echo "Ruby started"
reqArray=("[]" "casecmp" "<=>" "concat" "end_with?" "match?" "partition" "replace" "split" "start_with?" "strip" "slice" "swapcase" "to_f" "to_i" "downcase" "upcase" "lstrip" "rstrip")
for str in ${reqArray[@]}; do
  INPUT=$(curl --location --request GET "https://api.github.com/search/code?q=$str+in:file+language:ruby" --header 'Authorization: Token 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')
  echo ${str}
  echo answer_length ${#INPUT}
  sub1=${INPUT#*:} 
  sub2=${INPUT#*,}
  left=$((${#INPUT} - ${#sub1} + 1)) # ok
  right=$((${#INPUT} - ${#sub2}))
  length=$(($right - $left - 1))
  result=${INPUT:${left}:${length}} 
  echo $str $result >> results.txt
  sleep 61
done
echo "Ruby finished"

echo "#################################################################################################"
