package Part2;

import Part1.BinaryTree;

/**
 * FamilyTree class
 * Created by yacikgoz on 8.04.2017.
 */
public class FamilyTree extends BinaryTree<Person> {

    /**
     * add metod
     * @param name name
     * @param parentName parent name
     * @param nickName nick name
     * @return true if add operation is successful
     */
    public boolean add(String name, String parentName, String nickName){
        // person objesi oluştur

        Person newPerson = new Person(name, parentName, nickName);
        //personin olup olmadigini check et
        if(checkPerson(newPerson, root))
            return addToTree(root, newPerson);
        else
            return false;
    }

    /**
     * recursive addToTree metod
     * @param personNode person node
     * @param person person object
     * @return true if add operation is successful
     */
    private boolean addToTree(Node<Person> personNode, Person person) {
        if(personNode == null)
            return false;
        if(personNode.getData().checkParent(person)){
            Node<Person> node = personNode.getLeft();
                if (node != null) {
                    //saga dogru kardesler uzerinde git
                    while (node.getRight() != null)
                        node = node.getRight();
                    // en saga ekle
                    node.setRight(new Node<>(person));
                } else //cocugu ekle
                    personNode.setLeft(new Node<>(person));
                return true;
        }
        // recursive cagri
        return addToTree(personNode.getLeft(), person)|| addToTree(personNode.getRight(), person);
    }

    /**
     * family tree'de parametre olarak verilen
     * person objesinin olup olmadigini kontrol et
     * @param person objesi
     * @param node node referansi
     * @return true person objesi tree'de yoksa, false varsa
     */
    private boolean checkPerson(Person person, Node<Person> node){
        if(node==null)
            return true;
        else if(person.equals(node.getData()))
            return false;

        return checkPerson(person, node.getLeft()) || checkPerson(person, node.getRight());
    }

    /**
     * ilk elemani family tree'ye ekleyen constructor
     * @param rootName root eleman ismi
     */
    public FamilyTree(String rootName){
        super.add(new Person(rootName,"",""));
    }
}
