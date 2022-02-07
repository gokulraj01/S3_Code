mkdir -p class
comp_res=$(javac -d class "$1")
if [ comp_res=="" ]; then
    echo "Compile Successful..."
    echo "--- ClassList ---"
    ls class
    echo "-----------------"
    read -p "Enter class to run: " cname
    java -classpath class "$cname"
    echo "-----"
else
    echo "COMPILE FAILED !!"
fi