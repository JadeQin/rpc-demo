namespace java me.qinlu.thrift

typedef i32 int
typedef i64 long


service MultiplicationService{
  int multiply(1:int n1, 2:int n2),
  void zip()
}

struct Insanity
{
   map<int, long> userMap,
   list<long> xtructs
}

struct Own{
  list<int> list1
}

struct Xtruct
{
  1:  string string_thing,
  4:  byte   byte_thing,
  9:  i32    i32_thing,
  11: i64    i64_thing
}
