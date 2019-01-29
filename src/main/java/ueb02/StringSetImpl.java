package ueb02;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {
    class Element {
        String val;
        Element left, right;

        Element(String val, Element left, Element right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private int size() {
            int n = 1;

            if(this.left != null) {
                n += this.left.size();
            }

            if(this.right != null) {
                n += this.right.size();
            }

            return n;
        }

    }

    Element root;

    public boolean add(String s) {
        if (root == null) {
            root = new Element(s, null, null);
            return true;
        }

        Element it = root;

        while (it != null) {
            if (it.val.compareTo(s) == 0) {
                return false;
            } else if (it.val.compareTo(s) > 0) {
                if(it.left == null) {
                    it.left = new Element(s, null,null);
                    return true;
                } else {
                    it = it.left;
                }
            } else if(it.val.compareTo(s) < 0) {
                if(it.right == null) {
                    it.right = new Element(s, null, null);
                    return true;
                } else {
                    it = it.right;
                }
            }
        }
        return false;
    }

    public boolean contains(String s) {
        if(root == null) {
            return false;
        }

        Element it = root;

        while(it != null) {
            if(it.val.compareTo(s) == 0) {
                return true;
            } else if(it.val.compareTo(s) > 0) {
                if(it.left == null) {
                    return false;
                } else {
                    it = it.left;
                }
            } else if(it.val.compareTo(s) < 0) {
                if(it.right == null) {
                    return false;
                } else {
                    it = it.right;
                }
            }
        }
        return false;
    }

    public String remove(String s) {
        if(root == null) {
            throw new NoSuchElementException();
        }

        if(root.val.equals(s)){
            return removeRoot();
        }

        Element it = root;
        while(it != null) {
            if(it.val.compareTo(s) > 0) {
                if(it.left != null && it.left.val.compareTo(s) == 0) {
                    return removeElement(it, it.left);
                }
                it = it.left;
            } else if(it.val.compareTo(s) < 0) {
                if(it.right != null && it.right.val.compareTo(s) == 0) {
                    return removeElement(it, it.right);
                }
                it = it.right;
            }
        }
        throw new NoSuchElementException();
    }

    private String removeRoot() {
        Element e = root;
        if(e.left == null && root.right == null) {
            root = null;
        } else if(e.left == null) {
            root = e.right;
        } else if(e.right == null) {
            root = e.left;
        } else {
            root = e.left;
            addElement(e.right);
        }
        return e.val;
    }

    private String removeElement(Element parent, Element element) {
        if(element == parent.left) {
            parent.left = null;
        } else {
            parent.right = null;
        }

        addElement(element.left);
        addElement(element.right);

        return element.val;
    }

    private void addElement(Element e) {
        if (e == null)
            return;

        if (root == null) {
            root = e;
            return;
        }

        Element it = root;
        while (it != null) {
            if (it.val.equals(e.val))
                return;
            else if (e.val.compareTo(it.val) < 0) {
                if (it.left == null) {
                    it.left = e;
                    return;
                } else
                    it = it.left;
            } else {
                if (it.right == null) {
                    it.right = e;
                    return;
                } else
                    it = it.right;
            }
        }
    }

    public int size() {
        if(root == null) {
            return 0;
        } else {
            return root.size();
        }
    }
}
