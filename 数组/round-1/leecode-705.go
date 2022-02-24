package round_1

//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
//实现 MyHashSet 类：
//
//void add(key) 向哈希集合中插入值 key 。
//bool contains(key) 返回哈希集合中是否存在这个值 key 。
//void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
//提示：
//
//0 <= key <= 1000000
//最多调用 10000 次 add、remove 和 contains

type MyHashSet struct {
	mark []bool
}

func Constructor() MyHashSet {
	return MyHashSet{
		mark: make([]bool, 1000000),
	}
}

func (this *MyHashSet) Add(key int) {
	this.mark[key] = true
}

func (this *MyHashSet) Remove(key int) {
	this.mark[key] = false
}

func (this *MyHashSet) Contains(key int) bool {
	return this.mark[key] == true
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */
