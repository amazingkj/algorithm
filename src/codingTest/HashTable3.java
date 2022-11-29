package codingTest;

public class HashTable3 {
	//Key-Value
	//Hash Function - Hash, Hash Value, Hash Address / Hash Table - Slot

		public Slot[] hashTable;
		
		public HashTable3(Integer size) {
			this.hashTable = new Slot[size];
			
		}
		
		public class Slot {
			String key;
			String value;
			Slot(String key, String value) {
				this.key=key;
				this.value=value;
			}
		}
		
		public int hashFunc(String Key) {
			return (int)(Key.charAt(0)) % this.hashTable.length;
		}
		
		public boolean saveData(String key, String value) {
			Integer address = this.hashFunc(key);
			if(this.hashTable[address] !=null) {
				if(this.hashTable[address].key==key) {
					this.hashTable[address].value=value;
					return true;
					
				}else {
					Integer currAddress=address+1;
					while (this.hashTable[currAddress] != null) {
						if(this.hashTable[currAddress].key == key) {
							this.hashTable[currAddress].value = value;
							return true;
						}else {
							currAddress++;
							if(currAddress >= this.hashTable.length) {
								return false;
							}
						}
					}
					
					this.hashTable[currAddress] = new Slot(key,value);
					return true;
				}
				
			}else {
				this.hashTable[address]=new Slot(key, value);
			}
			return true;
		}
		
		
		public String getData(String key) {
			Integer address =this.hashFunc(key);
			if(this.hashTable[address]!=null) {  			//해당 주소에 대한 슬롯이 있으면 
				if(this.hashTable[address].key == key) { 	//현재 테이블 슬롯에 있는 키가 내가 찾는 키가 맞다면
					return this.hashTable[address].value; 	//해당키의 값을 리턴
				}else {										//그렇지 않으면
					Integer currAddress = address +1;		//다음 슬롯으로 넘어가서
					while (this.hashTable[currAddress] != null) {		//다음 슬롯이 null 이 아니라면				
						if(this.hashTable[currAddress].key == key) {	//해당 슬롯이 내가 찾는 키인지 확인 
							return this.hashTable[currAddress].value;	//맞다면 해당 값을 리턴
						}else {											//다르다면 
							currAddress++;								//다시 다음 주소로 
							if(currAddress >= this.hashTable.length) {	//끝까지 체크했다면
								return null;							//데이터를 검색하지도 저장하지도 않는다. 
							}
						}
							
					}
					return null;
				}
				 
			}else {
				return null;
			}
			
		}

	
	
	public static void main(String[] args) {
		HashTable3 mainObject = new HashTable3(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.saveData("Dave", "01065667777");
		mainObject.saveData("David", "01088889999");
		mainObject.saveData("Ddddd", "01099996666");
		System.out.println(mainObject.getData("Ddddd"));
		
	}

}
