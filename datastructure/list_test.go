package datastructure

import (
	"fmt"
	"testing"
)

func checkListNodePointer(t *testing.T, l *List, nds []*node) {
	if l.length != len(nds) {
		t.Errorf("l.length = %d, want: %d", l.length, len(nds))
		return
	}
	loop := 0
	for l.head != nil {
		t.Log(l.head.val)
		t.Log(nds[loop].val)
		loop++
		l.head = l.head.next
	}
}

func TestList(t *testing.T) {
	l := New()

	l.InsertFront(10)
	fmt.Println(l.length)
	checkListNodePointer(t, l, []*node{&node{val: 10}})
}
