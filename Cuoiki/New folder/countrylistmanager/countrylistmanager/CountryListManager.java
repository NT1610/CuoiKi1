package com.countrylistmanager;

import java.util.*;

public class CountryListManager {

    // Singleton pattern
    private static CountryListManager instance;

    private List<AbstractCountry> countryList;

    private CountryListManager() {
        countryList = new LinkedList<>();
    }

    public static CountryListManager getInstance() {
        return instance;
    }

    public List<AbstractCountry> getCountryList() {
        return this.countryList;
    }

    public void append(AbstractCountry country) {
        this.countryList.add(country);
    }

    public void add(AbstractCountry country, int index) {
        this.countryList.add(index, country);
    }

    public void remove(int index) {
        this.countryList.remove(index);
    }

    public void remove(AbstractCountry country) {
        this.countryList.remove(country);
    }

    public AbstractCountry countryAt(int index) {
        return this.countryList.get(index);
    }

    public List<AbstractCountry> sortIncreasingByPopulation() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return left.getPopulation() - right.getPopulation();
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortDecreasingByPopulation() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return right.getPopulation() - left.getPopulation();
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortIncreasingByArea() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(left.getArea(), right.getArea());
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortDecreasingByArea() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(right.getArea(), left.getArea());
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortIncreasingByGdp() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(left.getGdp(), right.getGdp());
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortDecreasingByGdp() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        Collections.sort(newList, new Comparator<AbstractCountry>() {
            @Override
            public int compare(AbstractCountry left, AbstractCountry right) {
                return Double.compare(right.getGdp(), left.getGdp());
            }
        });
        return newList;
    }

    public List<AbstractCountry> filterContinent(String continent) {
        List<AbstractCountry> newList = new ArrayList<>();
        for (AbstractCountry i : countryList) {
            if (i.getName().equals(continent)) {
                newList.add(i);
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterMostPopulousCountries(int howMany) {
        List<AbstractCountry> mostPopulousCountries = new ArrayList<>();
        List<AbstractCountry> newList = sortDecreasingByPopulation();
        for (int i = 0; i < howMany; i++) {
            mostPopulousCountries.add(newList.get(i));
        }
        return mostPopulousCountries;
    }

    public List<AbstractCountry> filterLeastPopulousCountries(int howMany) {
        List<AbstractCountry> leastPopulousCountries = new ArrayList<>();
        List<AbstractCountry> newList = sortIncreasingByPopulation();
        for (int i = 0; i < howMany; i++) {
            leastPopulousCountries.add(newList.get(i));
        }
        return leastPopulousCountries;
    }

    public List<AbstractCountry> filterLargestAreaCountries(int howMany) {
        List<AbstractCountry> largestAreaCountries = new ArrayList<>();
        List<AbstractCountry> newList = sortDecreasingByArea();
        for (int i = 0; i < howMany; i++) {
            largestAreaCountries.add(newList.get(i));
        }
        return largestAreaCountries;
    }

    public List<AbstractCountry> filterSmallestAreaCountries(int howMany) {
        List<AbstractCountry> smallestAreaCountries = new ArrayList<>();
        List<AbstractCountry> newList = sortDecreasingByArea();
        for (int i = 0; i < howMany; i++) {
            smallestAreaCountries.add(newList.get(i));
        }
        return smallestAreaCountries;
    }

    public List<AbstractCountry> filterHighestGdpCountries(int howMany) {
        List<AbstractCountry> highestGdpCountries = new ArrayList<>();
        List<AbstractCountry> newList = sortDecreasingByGdp();
        for (int i = 0; i < howMany; i++) {
            highestGdpCountries.add(newList.get(i));
        }
        return highestGdpCountries;
    }

    public List<AbstractCountry> filterLowestGdpCountries(int howMany) {
        List<AbstractCountry> lowestGdpCountries = new ArrayList<>();
        List<AbstractCountry> newList = sortIncreasingByGdp();
        for (int i = 0; i < howMany; i++) {
            lowestGdpCountries.add(newList.get(i));
        }
        return lowestGdpCountries;
    }

    public static String codeOfCountriesToString(List<AbstractCountry> countryList) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (AbstractCountry country : countryList) {
            codeOfCountries.append(country.getCode()).append(" ");
        }
        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(List<AbstractCountry> countryList) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (AbstractCountry country : countryList) {
            countriesString.append(country.toString()).append("\n");
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}
