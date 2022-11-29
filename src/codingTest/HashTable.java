package codingTest;

public class HashTable {
	//Key-Value
	//Hash Function - Hash, Hash Value, Hash Address / Hash Table - Slot


		public Slot[] hashTable;
		
		public HashTable(Integer size) {
			this.hashTable = new Slot[size];
			
		}
		
		public class Slot {
			String value;
			Slot(String value) {
				this.value=value;
			}
		}
		
		public int hashFunc(String Key) {
			return (int)(Key.charAt(0)) % this.hashTable.length;
		}
		
		public boolean saveData(String key, String value) {
			Integer address = this.hashFunc(key);
			if(this.hashTable[address] !=null) {
				this.hashTable[address].value = value;
			}else {
				this.hashTable[address]=new Slot(value);
			}
			return true;
		}
		
		
		public String getData(String key) {
			Integer address =this.hashFunc(key);
			if(this.hashTable[address]!=null) {
				return this.hashTable[address].value;
			}else {
				return null;
			}
		}
		

	
	
		public static void main(String[] args) {
			HashTable2 mainObject = new HashTable2(20);
			mainObject.saveData("DaveLee", "01022223333");
			mainObject.saveData("fun-coding", "01033334444");
			mainObject.saveData("Dave", "01065667777");
			mainObject.saveData("David", "01088889999");
			mainObject.saveData("Ddddd", "01099996666");
			System.out.println(mainObject.getData("DaveLee"));
			System.out.println(mainObject.getData("David"));
		}

}
