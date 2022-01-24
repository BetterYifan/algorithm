package datastructure

import (
	"errors"
)

var (
	IndexInvalid = errors.New("index is illegal")
)

type node struct {
	val  interface{}
	next *node
}

type List struct {
	head   *node
	length int
}

func (l *List) Init() *List {
	l.head = new(node)
	return l
}

func New() *List { return new(List).Init() }

func (l *List) lazyInit() {
	if l == nil {
		l.Init()
	}
}

//insertElem . insert elem at index
func (l *List) insertElem(index int, elem interface{}) error {
	if index > l.length || index <= 0 {
		return IndexInvalid
	}
	pre := l.head
	nd := &node{val: elem}
	if index == 1 {
		nd.next = pre
		l.head = nd
	} else {
		for count := 1; count < index-1; count++ {
			pre = pre.next
		}
		nd.next = pre.next
		pre.next = nd
	}
	l.length++
	return nil
}

//InsertFront insert first
func (l *List) InsertFront(elem interface{}) error {
	l.lazyInit()
	return l.insertElem(1, elem)
}

func (l *List) InsertBehind(elem interface{}) error {
	l.lazyInit()
	return l.insertElem(l.length, elem)
}
