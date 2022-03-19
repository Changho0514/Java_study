import java.util.ArrayList;
import java.util.HashMap;

public class PokeBag {
    // HashMap 이지만, key-value가 1:1 대응이 아닌 key 하나당 값이 여러개 매칭 되길원한다면
    // value를 ArrayList로 받아오면 된다!
    // pokemons의 전체적인 객체는 그래도 HashMap의 형태이기 때문에 new HashMap<>()으로 인스턴스를 만들어준다.
    private final HashMap<String, ArrayList<Pokemon>> pokemons = new HashMap<>();

    // name의 이름을 갖는 포켓몬을 모두 가져오기
    // name은 key로서 사용되고 있고,(Pokemon.java 참고)
    // HashMap pokemons에서 key으로 가져오려면 HashMap.get(key) 이니까!
    public ArrayList<Pokemon> getPokemons(String name) {
        return pokemons.get(name); // name 을 가진 포켓몬 ArrayList가 return 된다.
    }

    // pokemons에 새로운 Pokemon 을 넣어주는 메소드
    // getPokemons에서 name의 이름을 가진 포켓몬 ArrayList가 넘어왔을텐데
    // 존재하지 않는다면 .put(name, ArrayList<Pokemon>())으로 넣어주어야 한다.
    // 존재한다면 ArrayList에 추가하는 것이므로,
    // getPokemons(pokemon.name)으로 ArrayList를 받아와서 .add로 넣어주자
    public void add(Pokemon pokemon) {
        if (getPokemons(pokemon.name) == null){
            pokemons.put(pokemon.name, new ArrayList<Pokemon>());
        }

        getPokemons(pokemon.name).add(pokemon);
    }
    /*
    해당 이름을 가진 포켓몬중에 가장 센 포켓몬을 리턴해주는 메소드
    우선 ArrayList를 받아오는게 편하다
    getPokemons(name)으로 해당 포켓몬의 ArrayList를 받아오고 변수에 저장해준다.
    존재하지 않으면 null을 리턴하고
    Pokemon strongest = null; 로 초기화 한후에
    하나씩 비교하며 최신화 시켜주자.
    처음에 strongest가 존재하지 않으면 에러가 뜨니 strongest == null 조건을 적어주지 않으면 안된다.
    존재하지 않으면 null을 리턴해야 하는것을 잊지말자
     */
    public Pokemon getStrongest(String name) {
        ArrayList<Pokemon> pokemonList = getPokemons(name);

        if (pokemonList == null) {
            return null;
        }

        Pokemon strongest = null;
        for (Pokemon pokemon : getPokemons(name)) {
            if (strongest == null || pokemon.cp > strongest.cp) {
                strongest = pokemon;
            }
        }
        return strongest;
    }

    /*
    모든 포켓몬중에 가장 센 포켓몬을 리턴하는 메소드

    pokemons.keySet()으로 모든 key를 set으로 받아오고,
    Pokemon p 변수에 getStrongest(key)를 넣어주어 가장 센 포켓몬을 찾는다.
    for 문 안에 if문을 넣어 strongest를 초기화 시켜준다.
     */
    public Pokemon getStrongest() {
        Pokemon strongest = null;

        for (String key : pokemons.keySet()) {
            Pokemon p = getStrongest(key);


            if (strongest == null || p.cp > strongest.cp) {
                strongest = p;
            }
        }

        return strongest;
    }
}