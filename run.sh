#!/bin/sh

# Maven
case "$1" in
  --package)
     echo "start packaging..."
     mvn clean package
  ;;
  *)
     echo "none..."
  ;;
esac

# Run app
java -cp target/dependency/*:target/classes "$2"

